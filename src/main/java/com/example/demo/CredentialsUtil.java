package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.identity.UsernamePasswordCredential;
import com.azure.identity.UsernamePasswordCredentialBuilder;

@Configuration
public class CredentialsUtil {

	/**
	 * Authenticate with username, password.
	 */
	@Bean
	public UsernamePasswordCredential createUserNamePasswordCredential() {
	    UsernamePasswordCredential usernamePasswordCredential = new UsernamePasswordCredentialBuilder()
	        .clientId("f547d4d3-45a6-4e22-9cb8-cc8e9e0d3e0c")
	        .username("jadhalidocs@gmail.com")
	        .password("J@1M0d1J1K1")
	        .build();	
	    return usernamePasswordCredential;
	    // Azure SDK client builders accept the credential as a parameter
	    //SecretClient client = new SecretClientBuilder()
	    //    .vaultUrl("https://{YOUR_VAULT_NAME}.vault.azure.net")
	    //    .credential(usernamePasswordCredential)
	    //    .buildClient();
	}
}
