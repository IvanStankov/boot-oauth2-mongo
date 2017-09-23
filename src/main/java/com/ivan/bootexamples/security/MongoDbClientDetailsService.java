package com.ivan.bootexamples.security;

import com.ivan.bootexamples.entity.Client;
import com.ivan.bootexamples.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("mongodbClientDetailsService")
public class MongoDbClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        final Client client = this.clientRepository.findByClientId(clientId);

        final String scopes = this.joinStringWithComma(client.getScopes());
        final String grantTypes = this.joinStringWithComma(client.getGrantTypes());
        final String authorities = this.joinStringWithComma(client.getAuthorities());

        final BaseClientDetails baseClientDetails = new BaseClientDetails(client.getClientId(), client.getResourceId(),
                scopes, grantTypes, authorities);
        baseClientDetails.setClientSecret(client.getClientSecret());
        return baseClientDetails;
    }

    private String joinStringWithComma(final List<String> strings) {
        return strings
                .stream()
                .collect(Collectors.joining(","));
    }
}
