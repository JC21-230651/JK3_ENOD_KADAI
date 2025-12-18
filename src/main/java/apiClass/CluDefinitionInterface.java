package apiClass;

public interface CluDefinitionInterface {
	// モデルのデプロイ　→　予測 URL
	static final String apiUrl = "https://gyutan230651.cognitiveservices.azure.com/language/:analyze-conversations?api-version=2024-11-15-preview";
	
	//　プロジェクト設定　→　 主キー:
	static final String subscriptionKey = "e71298d13bbd40409d74abc940127cf5";
	
	// プロジェクトを見る
	static final String projectName = "gyutan230651";
	
	// モデルのデプロイを見る
	static final String deploymentName = "gyutanDeploy";
}
