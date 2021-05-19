# CONDOMEASY-BACKEND

## Definir variáveis de ambiente

#### Windows:

* Passo 1. Clicar com o botão direito em cima da opção 'Meu computador'.  

* Passo 2. Clicar na opção 'Configurações Avançadas do Sistema'.  

* Passo 3. Clicar na opção 'Variáveis de ambiente...'.

* Passo 4. Clicar em 'Novo' e adicionar as seguintes variáveis de sistema:

> - CONDO_URL_DB_CONNECTION
> - CONDO_USER_DB_CONNECTION
> - CONDO_PASSWORD_DB_CONNECTION
> - JWT_SECRET_KEY

* Passo 5. Após adicionar, reinicie o computador.

>[!WARNING]
>Os valores das variáveis serão passados via whatsapp.

> Rotas
> - Adicionar usuário:
>   - [POST] localhost:8080/user
>   - JSON:
> ```
>{
>	"nome": "",
>	"blocoApto": "",
>	"cpf": "",
>	"usuario": "",
>	"senha": "",
>	"perfilId": 0,
>	"numeroApto": 0,
>	"condominioId": 0,
>	"email": "",
>	"telefone": "",
>	"sobrenome": ""
>}
> ```