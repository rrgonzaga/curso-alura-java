# curso-alura-java
Códigos fonte dos cursos da Alura de Java

# curso: Servlet parte 2: Autenticacão, autorização e o padrão MVC
## Aula 04: Http Session
- O que foi aprendido: 
- Por padrão, o navegador não envia nenhuma identificação sobre o usuário;
- Quando o Tomcat recebe uma nova requisição (sem identificação), gerará um ID;
- O ID fica salvo no cookie de nome JSessionID; 
- O ID é um hash (número aleatório);
- O cookie é anexado à resposta HTTP;
- O navegador reenvia o cookie automaticamente nas próximas requisições;
- O Tomcat gera, além do ID, um objeto chamado HttpSession;
- A vida do objeto HttpSession fica atrelado ao ID;
- Para ter acesso à HttpSession, basta chamar request.getSession();
- Usamos a HttpSession para guardar dados sobre o usuário (login, permissões, carrinho de compra, config. de preferencias);
- A HttpSession tem um ciclo de vida e será automaticamente invalidada;

# curso: Servlet parte 2: Autenticacão, autorização e o padrão MVC
## Aula 05: Aplicando filtros
- O filtro é como uma porta que é colocada entre o navegador e o Servlet, e ele permite filtrar as requisições. Da mesma forma que conseguimos mapear uma requisição para um Servlet, conseguimos mapear uma requisição para um filtro - no entanto, o filtro tem uma responsabilidade a mais: ele consegue parar uma requisição. Usamos o FilterChain para mandar a requisição para frente.
- O que foi aprendido:
- Um Filter e Servlet são bem parecidos;
- Comparado com Servlet, o Filter tem o poder de parar o fluxo;
- Para escrever um filtro, devemos implementar a interface javax.servlet.Filter;
- Para mapear o filtro, usamos a anotação @WebFilter ou o web.xml;
- Vários filtros podem funcionar numa cadeia (um chama o próximo, mas todos são independentes);
- Para definir a ordem de execução, devemos mapear os filtros no web.xml;
- Um filtro recebe como parâmetro, do método doFilter, um ServletRequest e um ServletResponse, ambos, são interfaces mais genéricas do que HttpServletRequeest e HttpServletResponse;
- Para chamar o próximo filtro na cadeia, usamos o objeto FilterChain;

# curso: Servlet parte 2: Autenticacão, autorização e o padrão MVC
## Aula 06: Introdução ao Web Service
- Web Service é uma funcionalidade que conseguimos chamar remotamente através do protocolo HTTP, usando, por exemplo, o Java Servet, e que devolve os dados em um formato genérico, como JSON ou XML. Quando falamos de web services, temos que dar suporte aos vários tipos de clientes, não apenas navegadores.
- O que foi aprendido:
- Que um web service usa HTML, JSON ou XML como retorno; 
- Que um web service oferece alguma funcionalidade para seu cliente; 
- Que um web service é útil quando precisa oferecer uma funcionalidade para cliente diferentes (browsers, celulares, etc.); 
- Que para o web service não importa se o cliente foi escrito em Java, C# ou outra linguagem, pois usamos um protocolo e formatos independentes da plataforma, o HTTP geralmente;
- Como gerar JSON no código Java através de GSON;
- Como gerar XML no código Java através de XStream;
- Como escrever um web service através de um HttpServlet;
- Como criar um cliente HTTP a partir do código Java, usando a biblioteca Apache HttpClient; 
- Como gerar JSON ou XML a partir do cabeçalho Accept da requisição.

# curso: Servlet parte 2: Autenticacão, autorização e o padrão MVC
## Aula 07: Deploy no Jetty
- O que foi aprendido:
- A disponibilizar a nossa aplicação no servlet container Jetty; 
- Que Servlet é uma especificação; 
- Que a especificação Servlet faz parte do Java EE/Jakarta EE; 
- Que, ao usar Servlet, programamos independentemente do servidor/container; 
- A diferença entre servlet container e application server, onde os Application Servers, além de mapear requisições, são muito mais robustos e oferecem um número maior de recursos, diferentemente dos Servlet Containers, que apenas mapeiam as requisições do cliente.

# curso: Spring MVC I: Criando aplicações web
## Aula 01: Começando com Spring MVC
- Criando o projeto casadocodigo utilizando a ferramenta JBoss Forge. A grande vantagem ao utilizarmos o JBoss Forge é agilizar a configuração inicial do projeto, permitindo ganhar tempo indo direto para o código. O JBoss Forge é um gerador de projetos Java, e ele gera toda a estrutura base do projeto integrada ao Maven. Além disso, configura dependências (bibliotecas e frameworks), estrutura de pastas e gera configurações iniciais que normalmente envolve arquivos XML.









