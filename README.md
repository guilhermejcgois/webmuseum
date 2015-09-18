# webmuseum
Este repositório contém as versões de um museu virtual construído por mim durante minhas atividades com teste funcional de uma linha de produto de software, um projeto de extensão da UFSCar Sorocaba, financiado pela ProEX.
## Coleta de métricas
A coleta de métricas do projeto foi feita utilizando as seguintes ferramentas além de IDE ([Netbeans](netbeans.org)), SGBD (MySQL) e Servidor de Aplicação ([Glassfish](glassfish.java.net)), [Jenkins](jenkins-ci.org) (Integração Contínua), [Github](github.com) (Controle de Versões) e [SonarQube](sonarqube.org) (Coleta de Métricas).
## Instalando e Configurando o Ambiente
### IDE
#### Netbeans
A IDE utilizada no desenvolvimento, tanto da linha como do projeto web, foi o [Netbeans v8.0.2 para Java EE](https://netbeans.org/downloads/index.html), a versão atual na data de escrita deste tutorial. Sua instalação e configuração não possuem segredos, só não se esqueça de dentre as opções adicionais ofericidas pelo instalador de ao menos instalar também o Glassfish. Demais configurações relacionadas às outras ferramentas virão a seguir.
### SGBD
#### MySQL
### Servidor de Aplicação
#### Glassfish
Para podermos rodar nosso projeto web, estamos trabalhando com o Glassfish como servidor de aplicação, caso não tenha instalado o Glassfish junto com o Netbeans, você pode baixar ele [aqui](https://glassfish.java.net/download.html). Sua instalação basicamente consiste em descompactar um arquivo zip, no próprio site do Glassfish existem informações para instalá-lo e rodá-lo.
### Integração Contínua com Jenkins
A instalação do [jenkins](http://jenkins-ci.org/) consiste baixar um arquivo zip com os instaladores. Após a extração, você executa o arquivo 'setup.exe' e segue dando 'Próximo' toda a vida.
### SonarQube
Para a coleta de métricas estamos trabalhando com o [SonarQube v4.5.4](http://www.sonarqube.org/downloads/), como não é a versão mais recente, é necessário clicar no link 'show all versions', logo a pós a versão 4.5.5 (LTS). A instalação é simples, basta realizar o download do .zip e extrair no local desejável (que pode ser qualquer um). Desde que você esteja no windows, você precisa realizar uma simples configuração: a partir da pasta raíz do sonar, desça nos diretórios para bin/windows-x86-[32|64], de acordo com a arquitetura do seu windows, e execute como administrador o arquivo em lote InstallNTService.bat. Para executar o sonar, no windows você deve entrar no subdiretório referente ao seu windows em bin e executar como administrador StartSonat.bat, enquanto que no windows você pode executar via o terminal com:
  $ sudo path/for/linux/version/start.sh
## Coletando as métricas
Para realizarmos a coleta de métricas de um projeto, estamos utilizando um plugin maven do sonarqube. Basicamente de configuração apenas precisamos adicionar o seguinte código para o arquivo pom do projeto:
```XML
  <profiles>
		<profile>
			<id>sonar-build</id>
			<properties>
				<sonar.exclusions></sonar.exclusions>
			</properties>
			<build>
				<plugins>
					<plugin>
						<groupId>org.codehaus.mojo</groupId>
						<artifactId>sonar-maven-plugin</artifactId>
						<version>2.3</version>
						<executions>
							<execution>
								<phase>verify</phase>
								<goals>
									<goal>sonar</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
				</plugins>
			</build>
		</profile>
	</profiles>
```
No Netbeans precisamos ainda fazer o seguinte: botão direito do mouse no projeto e vá para "Propriedades". No diálogo que vai abrir, vá para "Ações", e no dropbox de "Configuração" escolha sonar-build e pronto, pode dar um OK. Agora é só realizar uma build do projeto normalmente. Se você não estiver trabalhando com o Netbeans, se tiver utilizando o Jenkins por exemplo basta executar então o seguinte comando:
  $ mvn sonar:sonar
