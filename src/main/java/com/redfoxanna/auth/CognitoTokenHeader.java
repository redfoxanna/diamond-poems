package com.redfoxanna.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the header section of a JSON Web Token (JWT) issued by AWS Cognito.
 * This class provides methods to access the "kid" (Key ID) and "alg" (Algorithm)
 * properties from the token header.
 */
public class CognitoTokenHeader {

	@JsonProperty("kid")
	private String kid; // Key ID

	@JsonProperty("alg")
	private String alg; // Algorithm

	/**
	 * Retrieves the Key ID (kid) from the token header.
	 *
	 * @return The Key ID (kid) of the token header.
	 */
	public String getKid() {
		return kid;
	}

	/**
	 * Retrieves the algorithm (alg) from the token header.
	 *
	 * @return The algorithm (alg) of the token header.
	 */
	public String getAlg() {
		return alg;
	}
}
