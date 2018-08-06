import groovy.json.JsonSlurperClassic

def call(init_token) {
	String vaultToken = init_token
	String roleID = "20c5906d-6106-696e-9288-7e274df11f13"
	String vault_addr = 'http://127.0.0.1:8200'

	//retrieves secret_id for approle authentication
	sh(script: """
		curl --header "X-Vault-Token: $vaultToken" \
			 --request POST '$vault_addr'/v1/auth/approle/role/jenkins-azure/secret-id \
			 -o secretID.json
	""", returnStdout: true)
	String secretID = parseJSON("secretID.JSON").data.secret_id
	sh "rm secretID.json"



	//retrieves token to access secrets associated with given role
	String payload = '{"role_id": "$roleID", "secret_id": "$secretID"}'
	sh(script: """
		curl --request POST --data '$payload' '$vault_addr'/v1/auth/approle/login \
		-o secretToken.JSON
	""")
	String secretToken = parseJSON("secretToken.JSON").client_token
	sh "cat secretToken.JSON; echo $secretToken"

	// String output = sh(script: """
	
	// 	export VAULT_ADDR=$vault_addr
	// 	vault login $secretToken > /dev/null
	// 	vault kv get -field=id my-secret/data/subID
	// 	vault kv get -field=id my-secret/data/clientID
	// 	vault kv get -field=id my-secret/data/clientSecret
	// 	vault kv get -field=id my-secret/data/tenantID  
	// """, returnStdout: true)

	// sh """
	// 	export VAULT_ADDR=$vault_addr
	// 	echo $output
	// """


}


def parseJSON(file) {
	try{
		def tokenInfo = sh(script: "cat $file", returnStdout: true)
		def jsonSlurper = new JsonSlurperClassic()
		info = jsonSlurper.parseText(tokenInfo)
		return info
	}
	catch(Exception e) {
		return e.getMessage()
	}
}