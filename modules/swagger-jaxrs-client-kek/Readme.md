You can regenerate REST client using files from 'swagger-inputs' folder.
- Use 'swagger.yaml' file as input.
- Use 'config.json' file as config.
- Use 'jaxrs-cxf-client' as target language.
Example:
java -jar swagger-codegen-cli-2.4.12.jar generate -i swagger.yaml -l jaxrs-cxf-client -c config.json -o ./swagger-jaxrs-client-kek/
### LATEST USED VERSION
- swagger-codegen-cli-2.4.0-20181127.204020-367
Link to snapshots: https://oss.sonatype.org/content/repositories/snapshots/io/swagger/swagger-codegen-cli/2.4.0-SNAPSHOT/
Please usage 'latest used version' after every new generation.
p.s. keep in mgit add .ind that swagger-codegen tool contain a lot of bugs, so try to use the most recent snapshot, and then double-check result manually.  