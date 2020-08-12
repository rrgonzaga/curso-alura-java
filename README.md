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


