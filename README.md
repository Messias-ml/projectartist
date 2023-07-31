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
<p> Principio da responsabilidade unica. Cada metodo tem suas responsabilidades. <br> Exemplo:</p>

![Simple Page Aplication, methods.png](imgProject%2FSimple%20Page%20Aplication%2C%20methods.png)
>Como pode ver cada metodo tem suas responsabilidades muito bem definidas e UNICAS acima de tudo.
>> serchArtists apenas busca artistas, seja da maneira que for, tem a função de pesquisar por artistas e o metodo que utilizamos dele encontra esses artistas.

>>Já o outro, mostra os detalhes de um determinado artista, como o proprio nome indica. Utilizamos um metodo dele para adiquirir detalhes de um determinado artista.

>Como vimos, ambos metodós com responsabilidades unicas, veremos as interfaces agora, para mostrar ainda mais a aplicabilidade desse principio.
![interface_search_artists.png](imgProject%2Finterface_search_artists.png)
> 
> ![interface_findArtist.png](imgProject%2Finterface_findArtist.png)
> 
> Ambas interfaces separadas e com **RESPONSABILIDADES UNICAS**

>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
>> Codigo mais limpo e legível.
> 
>> Separação de responsabilidade, fortalecendo o clean code.
> 
>> Facilita manutenção no código. No caso das imagens mostradas, caso tivesse que fazer manutenção seria somente no metodo responsavél.
>> sendo assim, qualquer outro lugar que eu usasse esses metodos não precisaria mexer. Exemplo:
>>> Caso eu utilize o metodo findArtists do serchArtists em outros services e futuramente queira modificar este codigo, mexeria apenas na implementação dele e todos os outros services estariam intactos
>>> so modificariamos 1 lugar apesar de ser usado em vários.

<h3 style = "color: yellow">O-Open-Closed Principle</h3>
<p>Este principio diz que devemos estar aberto para extensão e fechados para modificação e é justamente oque acontece neste codigo.<br/>
Exemplo:</p>

> **SERVICE**
> 
> ![ArtistsService.png](imgProject%2FArtistsService.png)
> 
> Claramente o nosso service está fechado para alteração, póis ele utiliza metodos externos que tem a responsabilidade de fazer de executar a funcionalidade de fato.
> Vamos ao exemplo:
> 
> ![LocalImplementationService.png](imgProject%2FLocalImplementationService.png)
> 
> Nesta classe que está a implementação dos metodos, mas ela pode mudar, ou aumentar, ter mais metodos, ou até mudar a maneira que se faz a busca do artista, mas nosso querido service não tem nada haver com isso, ele apenas utiliza a INTERFACE, quem faz a implementação não tem nada haver com ele, por isso ele esta **FECHADO** para mudanças mais aberto para novas funcionalidades e novas extenções. Se tiver que mudar, quem irá mudar é o nosso ArtistImplementationService, a implementação pode mudar a vontade, com isso, mudarei apenas aqui e vai refletir em todo lugar que utilizo as interfaces que esta classe implementa.
>
> ![metodos implementados.png](imgProject%2Fmetodos%20implementados.png)
> 
> Estes são os metodos implementados da class ArtistImplementationService, com isso deixo então meu ArtistsService, totalmente fechado para mudança e aberto para novas funcionalidades e etc.
>> Veja, se eu quiser implementar novos metodos, mudar a maneira como se busca artistas, mudar a api de busca, tudo isso eu posso fazer modificando os codigos que estão acima, mas nunca a class ArtistsService.

>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
>> Codigo mais seguro.
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
> Repare o SearchArtists ela é uma interface que tem **ATUALMENTE** (pois pode mudar) a classe de implementação: ArtistImplementationService.
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
> Mostra que estamos no caminho certo e que usamos da maneira correta nossa extensão ou implementação.

<h3 style = "color: greenyellow">  I— Interface Segregation Principle:</h3>
<p> Este principio diz que não podemos forçar uma classe a utilizar interfaces e metodos que não irão utilizar.<br/>
Isso mostra mais uma vez que estamos alinhados a todos os principios, vou dar exemplos da utilização errada e como estamos fazendo (maneira correta.)
</p>

> Vamos imaginar o seguinte cenário:
> 
> **Atualmente** temos dentro de domain.service a class ArtistsService, que busca uma lista de artistas e também busca o detalhe de um determinado artista. Pronto, o nosso service atualmente tem essas duas funcionalidades.
><br> Além disso temos **ATUALMENTE** 2 interfaces separadas a searchArtists e a ArtistDetail, uma com a função de trazer os artistas e a outra de trazer os detalhes do artista.
> 
> ![LocalServiceAndInterfaces.png](imgProject%2FLocalServiceAndInterfaces.png)
> 
> Imagina que tivessemos 2 services invés de 1 só. 1 service buscaria por artistas e o outro traria os detalhes de um determinado artista.
> <br> E também que tivessemos 1 unica interface com os 2 metodos ArtistDetail e SearchArtists
> 
> ![implementationWrong.png](imgProject%2FimplementationWrong.png)
>
> <br/> se ambos usasse a interface Artists estaria errado, pois a mesma tem 2 metodos um para buscar os detalhes do artista e um para buscar artistas <br/>
>
>> ![artistInterface.png](imgProject%2FartistInterface.png)
>
> pensa comigo: porque o service de buscar artistas deveria ter consigo a possibilidade de usar o metodo de buscar <b>detalhes do artista</b>? Sendo que a função dele é apenas trazer a lista de artistas <br/>
> Bem como, porque no service de pesquisar artistas eu deveria ter a implementação que me faça ser capaz usar a busca de artistas? 
> <br/> Em ambos os casos não fazem sentido.

<h4> Maneira correta de se utilizar: </h4> 

>![LocalServiceAndInterfaces.png](imgProject%2FLocalServiceAndInterfaces.png)
>
> Temos apenas 1 service e 2 interfaces, poderiamos ter 2 services, mas não tem necessidade. O importante é que com isso, ao utilizarmos as interfaces cada uma tem sua devida responsabilidade <br/>
> e não implemento interfaces que não irei utilizar como no caso passado que o ArtistDetail usava interface que utilizava metodos de busca de artistas. <br/>
> 
> ![ArtistsService.png](imgProject%2FArtistsService.png)
> 
> Da maneira que se encontra atualmente, se eu quisse criar 2 service como fiz anteriormente, eu porderia, pois cada 1 utilizaria a sua respectiva interface e teria metodos apenas que faça sentido para aquele service.<br/>
> O service de buscar artista usaria a interface SearchArtists e o service de detalhes do artista usaria a interface ArtistDetail, com isso ele saberia apenas das suas responsabilidades.
> 
> Como utilizamos um unico service, deixamos ele mais geranerico, porém o nosso metodo de detalhe do artista usa apenas a interface relevante pra ele e assim por diante.
> 
> ![ArtistDetailInterface.png](imgProject%2FArtistDetailInterface.png)
> 
> ![SearchArtistsInterface.png](imgProject%2FSearchArtistsInterface.png)

>**BENEFICIO NA UTILIZAÇÃO DESTE PRINCIPIO:**
> > Economia de codigo e funcionalidade, pois uma classe não utiliza coisas desnecessarias somente o que é necessario pra ela.
> 
> > Deixa o codigo com melhor leitura e facil manutenção.
> 
> > Separa as responsabilidades.

<h3 style = "color: red">D — Dependency Inversion Principle</h3>
<p>Este principio diz sobre a inversão de dependencias e é exatamente o que mais utilizamos neste projeto.
Basicamente é você deixar seu codigo o mais DESACOPLADO possivel, evitar erros e muitas dependencias entre si. Ou seja, uma classe não pode depender de varias outras. <br/>
E se essa outra deixar de existir? Ou ser utilizada de uma outra maneira? Com isso, você deveria alterar em todo lugar que depende dessa classe e mudaria a maneira de se fazer. Em resumo, teria um baita trabalhão.
</p>

> 
>Exemplo de utilização:
>
> ![ArtistsService.png](imgProject%2FArtistsService.png)
> 
> Veja nosso ArtistsService, totalmente desacoplado.
> <br> Apesar da implementação dos metodos utilizados no service esta na class: ArtistImplementationService, nosso querido ArtistsService não depende dela. 
>
> ![LocalImplementationService.png](imgProject%2FLocalImplementationService.png)
>
>Ou seja, se hoje ou amanhã ela deixar de ser utilizada, não implementar mais a busca dos artistas ou o detalhe do artista, deixar de existir ou funcionar, ainda sim o ArtistService irá ta firme e forte, pois teremos outra classe que implementará as nossas interfaces: SearchArtists e ArtistDetail.
><br/> Isso é o que chamamos de inversão de dependencia, meu service deixou de depender da implementação e passou a utilizar interfaces que poderão ser implementadas por qualquer classe.
> <br/> Hoje as nossas interfaces são implementadas pela class ArtistImplementationService, mas se ela for descontinuada, podemos utilizar outras classes de implementação e ela passará a funcionar da maneira nova, com nova implementação. 
> <br> o mais legal disso, é que o nosso service não vai mudar nada, vai continuar da mesma maneira. Por isso há essa inversão de dependecia: Service não depende mais da implementação.
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
