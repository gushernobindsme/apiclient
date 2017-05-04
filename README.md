# apiclient
Jersey製のWebAPI出力サンプル。
GitHubのAPIからデータを取得し、標準出力またはファイル出力します。

## Main Dependencies
- Jersey Client 1.19.3
- Jackson Databind 2.8.8
- Commons Lang 2.6

## How To Use
mvnコマンドでビルドし、jarファイルを生成してください。

    mvn package

生成したjarファイルをそのまま実行することで起動できます。

    java -jar apiclient-0.0.1-SNAPSHOT-jar-with-dependencies.jar

起動時には、以下の引数を指定できます。
- C
  - APIから取得した情報をコンソールに出力します
  - 引数が未指定の場合、こちらの動作となります
- F
  - APIから取得した情報をファイルに出力します
  - ファイル名は「GitHubIssues_yyyyMMddHHmmss.txt」の形式です