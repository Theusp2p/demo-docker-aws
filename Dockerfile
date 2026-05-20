# Usa uma imagem oficial do Java extremamente leve (ajuste a versão para 17 ou 21 conforme seu projeto)
FROM eclipse-temurin:21-jdk-alpine

# Define a pasta de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar que você vai gerar no seu computador para dentro do container
COPY target/*.jar app.jar

# Sinaliza qual porta a aplicação vai usar internamente
EXPOSE 8080

# Comando que o container vai executar ao ser iniciado
ENTRYPOINT ["java", "-jar", "app.jar"]