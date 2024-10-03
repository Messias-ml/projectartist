# backend

Sistema criado para listar os artistas e verificar os detalhes deles.

Techs

![](https://img.shields.io/badge/Java-orange.svg)
![](https://img.shields.io/badge/version-17-orange.svg)


![](https://img.shields.io/badge/Spring_Boot-green.svg)
![](https://img.shields.io/badge/version-3.0.0-green.svg)

**ACESSO A DOCUMENTAÇÃO OPEN API:**
>Primeiro starte a aplicação, depois acesse o swagger.

Link:http://localhost:8080/swagger-ui/index.html

**ACESSO AO POSTMAN:**

>Primeiro starte a aplicação e depois importe o arquivo no seu postman:

Api teste Messias.postman_collection.json

<span style = "color: BLUE; font-size: 50px">S-</span>
<span style = "color: yellow; font-size: 50px">O-</span>
<span style = "color: fuchsia; font-size: 50px">L-</span>
<span style = "color: greenyellow; font-size: 50px">I-</span>
<span style = "color: red; font-size: 50px">D</span>
<p>Utilizamos SOLID no projeto e trabalhamos com interface no mesmo. <br/>
Alguns exemplos de utilizações PELAS INICIAIS DO SOLID. </p>

<h3 style="color: blue">S- Single Responsiblity Principle </h3>
<p> Principio da responsabilidade unica. Cada classe, metodo tem de ter suas responsabilidades únicas. <br> Exemplo:</p>

![Simple Page Aplication, methods.png](imgProject%2FSimple%20Page%20Aplication%2C%20methods.png)
>A classe <b>SerchArtists</b>  tem a unica responsabilidade de pesquisar artistas.
>> Conforme mostra na imagem, o atributo <b> serchArtists </b> exemplifica isso, utilizando o metodo dele que encontra esses artistas.
> 
>Já o outro <b>(artistDetail)</b>, mostra os detalhes de um determinado artista, como o proprio nome indica. Utilizamos um metodo dele para adiquirir esses.
> 
> <b style=color:red>OBSERVAÇÃO:</b> Apesar das classes terem relação entre si, (ambas diz sobre ARTIST) cada uma tem a sua devida responsabilidade e por isso deve ser separada, como foi corretamente. 

>Vou mostrar as interfaces agora, para que possa ver ainda mais a aplicabilidade desse principio.
>
>![interface_search_artists.png](imgProject%2Finterface_search_artists.png)
> 
> ![interface_findArtist.png](imgProject%2Finterface_findArtist.png)
> 
> Ambas interfaces separadas e com **RESPONSABILIDADES UNICAS**

>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
>
> - Codigo limpo
> - Manutenção facilitada
> - Menos complexidade em testes

<h3 style = "color: yellow">O-Open-Closed Principle</h3>
<p>Entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, mas fechadas para modificação e é justamente o que acontece nesse codigo.<br/>
Exemplo:</p>

> **SearchArtists**
> 
> Essa classe está fechada para mudança, mas nada impede dela expandir.
> 
> ![SearchArtists.png](imgProject%2FSearchArtists.png)
> 
> se no futuro eu precisar buscar os artistas pela idade, não so pelo nome, eu posso usar esse mesmo método <b>(findArtist)</b> em uma forma diferente usando o polimorfismo, dai eu não mexeria no atual para caber uma busca por idade dele.
>
>**MANEIRA ERRADA, SEM O USO DO OPEN-CLOSED:**
> 
> Se eu mexesse nesse método e adicionasse um Integer idade, eu estaria ferindo esse principio, posteriormente, teria de mexer também em testes unitarios que eu havia feito na classe e para piorar, poderia impactar o sistema como um todo, deixando de funcionar muita coisa pela necessidade da adição do atributo novo.
> 
>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
>> Codigo mais forte e intacto.
> 
>> Codigo mais legível e limpo.
> 
>> Facilita e muito a manutenção do codigo.
> 
>> Separa as responsabilidades.

<h3 style = "color: fuchsia"> L— Liskov Substitution Principle:</h3>
<p>Principio da substituição de Liskov.<br/> 
É um princípio bem simples, muito usado em herança que diz que 1 objeto derivado deve conseguir ser substituida pela sua classe base, ou seja, o filho deve conseguir substituir o pai tranquilamente. Vemos assim, que é muito comum quando usamos herança.
<br/> Porém vou mostrar outra maneira que usamos ALÉM da herança, este principio.
</p>

>No service, utilizamos uma interface que tem a sua classe de implementação.
> 
> ![ArtistsService.png](imgProject%2FArtistsService.png)
> 
> Repare o SearchArtists ela é uma interface que tem **ATUALMENTE** a classe de implementação: ArtistImplementationService.
> 
> ![LocalImplementationService.png](imgProject%2FLocalImplementationService.png)
> 
> No princípio de Liskov diz que ao substituimos uma classe derivada pela sua base deve funcionar normalmente.
> 
> Ou seja, se substituirmos a interface SearchArtists (classe derivada) pela classe ArtistImplementationService (classe base), deve funcionar normalmente.
>
> ![substituicao_liskov.png](imgProject%2Fsubstituicao_liskov.png)

>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
>
>Codigo coeso

<h3 style = "color: greenyellow">  I— Interface Segregation Principle:</h3>
<p> Este principio diz que não podemos forçar uma classe a utilizar interfaces e metodos que não irão utilizar.<br/>
Isso mostra mais uma vez que estamos alinhados a todos os principios, vou dar exemplos da utilização errada e como estamos fazendo (maneira correta.)
</p>

> Vamos imaginar o seguinte cenário:
> 
> **Atualmente** temos dentro de domain.service a class ArtistsService, que busca uma lista de artistas e também busca o detalhe de um determinado artista.
><br> Além disso temos **ATUALMENTE** 2 interfaces separadas a searchArtists e a ArtistDetail, uma com a função de trazer os artistas e a outra de trazer os detalhes do artista.
> 
> ![LocalServiceAndInterfaces.png](imgProject%2FLocalServiceAndInterfaces.png)
> 
> Imagina que tivessemos 2 services invés de 1 só. Um service buscaria por artistas e o outro traria os detalhes de um determinado artista.
> <br> E também que tivessemos 1 unica interface com os 2 metodos ArtistDetail e SearchArtists
> 
> ![implementationWrong.png](imgProject%2FimplementationWrong.png)
>
> <br/> se ambos usasse a interface Artists estariamos ferindo este principio <br/>
>
>> ![artistInterface.png](imgProject%2FartistInterface.png)
>
> pensa comigo: porque o service de buscar artistas deveria ter consigo a possibilidade de usar o metodo de buscar <b>detalhes do artista</b>? Sendo que a função dele é apenas trazer a lista de artistas. <br/>
> Nesse caso estaria sendo inutil o método e a classe de implementação obrigatoriamente teria de implementar os 2 métodos.
> <br/> Em ambos os casos não fazem sentido.
> 
>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
> > Economia de codigo e funcionalidade, pois uma classe não utiliza coisas desnecessarias somente o que é necessario pra ela.
> 
> > Deixa o codigo com melhor leitura e facil manutenção.
> 
> > Separa as responsabilidades.

<h3 style = "color: red">D — Dependency Inversion Principle</h3>
<p>Esse princípio sugere que, em vez de uma classe de alto nível depender diretamente de uma classe de baixo nível, ambas devem depender de uma interface ou abstração comum. Isso facilita a substituição de dependências e torna o código mais flexível.</p>

> 
>Exemplo de utilização:
>
> ![ArtistsService.png](imgProject%2FArtistsService.png)
> 
> Veja nosso ArtistsService, totalmente desacoplado.
> <br> Apesar da implementação dos metodos utilizados no service esta na class **ArtistImplementationService**, nosso querido ArtistsService não depende dela.
> Neste contexto o **ArtistsService** é a classe de alto nivel, e o **ArtistImplementationService** é a de baixo nivel.
>
> ![LocalImplementationService.png](imgProject%2FLocalImplementationService.png)
>
>Como pode ver nosso service utilizamos a interface **SearchArtists** e a **ArtistDetail**, fazendo com que não dependessemos das classes de implementação dessas interfaces (baixo nivel).
> Ou seja, se amanhã ou depois mudar a maneira de implementar essas buscas, nosso service ainda estará intacto o que vai mudar é apenas a classe de implementação. Sendo assim nosso codigo fica protegido e ainda é rebusto com grande possibilidade de crescimento e expansão.
><br/> Isso é o que chamamos de inversão de dependencia, meu service deixou de depender da implementação e passou a utilizar interfaces que poderão ser implementadas por qualquer classe.
> <br/> Hoje as nossas interfaces são implementadas pela class ArtistImplementationService, mas se ela for descontinuada, podemos utilizar outras classes de implementação e ela passará a funcionar da maneira nova, com nova implementação. 
>
>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
> 
> > Deixa a classe forte, fechada para mudança.
> 
> > Diminui drasticamente a chance de erros.
> 
> > Deixa o codigo pronto para o futuro.
> 
> > Separa as responsabilidades, ficando mais legivel o codigo.
> 
> > Pode ter muitas implementações, deixando ele apto para crescer.
> 
> >Codigo limpo
