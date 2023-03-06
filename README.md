# 🇵🇹 🇧🇷 Kotlin Multiplatform Mobile (KMM)
Desafios e resoluções a problemas relacionados ao desenvolvimento multiplataforma para mobile. Uma playlist imperdível do zero de quem teve que criar um projeto do zero. Conto os problemas que passei, como contornei, soluções encontradas, desafios etc. Pretendo documentar tudo aqui com código e videos no youtube para te ajudar. 

# O que você vai encontrar aqui?
Um projeto template já configurado com o modulo de dependencias para iniciar seu projeto multiplataforma móvel assim como vários vídeos com resoluções aos desafios comuns em um projeto kmm (vide branches abaixo)
  - techblog vantagens buildSrc: https://bit.ly/buildSrc

### Branches
# 🌳 **Branches**
| Nome e Descrição da Branch                                                                                                                                          | 📺 UML-Diagram |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------:|
| X1) **kmm_ready_to_use_sample_project** <br/> Projeto pronto para usar apenas com módulo de buildSrc (dependency management)                                        | <img src="https://user-images.githubusercontent.com/1042887/197234681-21fea81a-38be-461b-a91d-e27b77998e9e.png" width="100" height="137"> |
| X2) **kmm_with_shared_viewmodel** <br/> Projeto com X1) e viewmodel compartilhada em kmm                                                                            | <img src="https://user-images.githubusercontent.com/1042887/197233894-bc4412e7-d399-4a3a-9bc1-63348ffb0280.png" width="100" height="137"> |
| X3) **kmm_with_viewmodel_and_mockk** <br/> Projeto com X1-X2) e framework de mock para testes mockk                                                                 |  |
| X4) **kmm_viewmodel_mockk_database** <br/> Projeto com X1-X3) e banco de dados compartilhado sqldelight                                                             | <img src="https://user-images.githubusercontent.com/1042887/197234244-ea7403d4-53c0-49eb-8d8d-7f41a7737f7c.png" width="100" height="137"> |
| X5) **kmm_viewmodel_mockk_db_logger** <br/> Projeto com X1-X4) logger e shimmer                                                                                     | <img src="https://user-images.githubusercontent.com/1042887/197232046-d3361fb5-a4bd-4196-a4fd-78f5d296436d.png" width="100" height="137"> |
| X6) **kmm_with_instrumented_tests** <br/> Projeto com X1-X5) e testes instrumentados no androidMain                                                                 |  |
| X7) **kmm_with_ktor** <br/> Projeto com X1-X6) e ktor com respository e viewmodel retornando flow                                                                   | <img src="https://user-images.githubusercontent.com/1042887/202708517-d82c153e-0899-4644-b075-6201f8718810.png" width="100" height="137"> |
| X8) **kmm_shared_build_config** <br/> Projeto com X1-X7) e common config (buildConfig) compartilhado entre android e iOS                                            | <img src="https://user-images.githubusercontent.com/1042887/206722841-6f64628b-8926-4e1d-9561-c73f509ddd38.png" width="100" height="137"> |
| X9) **kmm_shared_image_resource** <br/> Projeto com X1-X8) e imagens compartilhadas entre android e iOS                                                             | <img src="https://user-images.githubusercontent.com/1042887/209583722-7e9733b8-c892-4c9b-83cd-845fa9b3f7cb.png" width="100" height="137"> |
| X10) **kmm_di_and_text_resource** <br/> Projeto com X1-X9) e textos compartilhados entre android e iOS                                                              | <img src="https://user-images.githubusercontent.com/1042887/209583839-a1e1f41c-d806-4417-9b22-3730c411023a.png" width="100" height="137"> |
| X11) **kmm_shared_color_resource** <br/> Projeto com X1-X10) e cores compartilhadas entre android e iOS                                                             |  |
| X12) **kmm_responsive_windows_size** <br/> Projeto com X1-X11) e telas responsivas compartilhadas entre android e iOS                                               |  |
| X13) **kmm_shared_settings** <br/> Projeto com X1-X12) e settings & preferências compartilhadas entre android e iOS                                                 |  |
| X14) **kmm_custom_style_fonts** <br/> Projeto com X1-X13) e estilos & fontes customizadas android                                                                   |  |
| X15) **kmm_usage_color_resource** <br/> Projeto com X1-X14) e uso prático do recurso de cores (theme) android                                                       |  |
| X16) **kmm_usage_spacing_resource** <br/> Projeto com X1-X15) e uso prático do recurso de dimens (spacing) android                                                  |  |
| X17) **kmm_shared_font_sizing** <br/> Projeto com X1-X16) e uso prático do recurso de tamanho de textos (font sizing) android                                       |  |
| X18) **kmm_custom_spacers** <br/> Projeto com X1-X17) e uso prático do spacer customizado fazendo uso dos espaços compartilhados (spacing resource) android         |  |
| X19) **kmm_custom_listview_item** <br/> Projeto com X1-X18) e uso prático do list view item customizado fazendo uso do theme compartilhado (color resource) android |  |
| X20) **kmm_custom_button_set** <br/> Projeto com X1-X19) e criação de um set de botões customizáveis jetpack compose android                                        |  |
| X21) **kmm_shared_dimens_resource** <br/> Projeto com X1-X20) e recursos de dimensões compartilhados em kmm e uso prático dos mesmos                                |  |
| X22) **kmm_debug_proguard_release** <br/> Projeto com X1-X21) como depurar, ofuscar e otimizar tamanho de código com proguard em release                            |  |
| X23) **kmm_textfield_with_erro_states** <br/> Projeto com X1-X22) como criar campo de texo e validar entradas de erro com estados em compose                        |  |
| X24) **kmm_loading_button_lottie** <br/> Projeto com X1-X23) como criar loading button com lottie em compose                                                        |  |
| X25) **kmm_alert_dialog_compose** <br/> Projeto com X1-X24) como criar alert dialogs, popups, custom dialogs em jetpack compose                                     |  |
| X26) **kmm_bottom_sheet_modal** <br/> Projeto com X1-X25) como criar bottomsheet dialog modal e padrão em jetpack compose                                           |  |
| X27) **kmm_accessibility_text** <br/> Projeto com X1-X26) como tratar textos e fontes gigantes em aparelhos pequenos em jetpack compose                             |  |
| X28) **kmm_online_offline_message** <br/> Projeto com X1-X27) como monitorar e exibir mensagem de conectividade em jetpack compose                                  |  |
| X29) **kmm_online_offline_message** <br/> Projeto com X1-X28) como expor e observar mudanças de estados em jetpack compose                                          |  |


# Posso Ajudar/Contribuir?
Seja também um multiplicador de conhecimento. Mostre esse repositório para sua **COMUNIDADE/GRUPO/SLACK MOBILE**
:
| 👇 Texto com link para postar nas redes sociais 👇 |
| :------------- |
| Repositório bacana em Português 🇵🇹 🇧🇷 para quem pretende criar um projeto multiplataforma mobile. Vai te evitar muita dor de cabeça e economizar muito tempo no trabalho. https://bit.ly/kotlin-multiplatform-mobile |

# 🧪 **CODELABS / VÍDEOS / RESOLUçÕES**
| Titulo        | 📺 Youtube Link |
| :------------- |:-------------:|
| ✔️ KMM - COMO CRIAR PROJETO KOTLIN MULTIPLATFORM MOBILE PARA ANDROID E IOS | <a href="https://youtu.be/xxxxxx" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BKMM%5D-COMO-CRIAR-PROJETO-KOTLIN-MULTIPLATFORM-MOBILE-PARA-ANDROID-E-IOS.png" width="100" height="56"></a> |
| ✔️ GERENCIAR DEPENDÊNCIAS - COMO CRIAR GERENCIAMENTO DE VERSÕES buildSrc EM PROJETO MULTIPLATFORMA | <a href="https://youtu.be/xxxxxx" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BGERENCIAR-DEPEND%C3%8ANCIAS%5D-COMO-CRIAR-GERENCIAMENTO-DE-VERS%C3%95ES-buildSrc-EM-PROJETO-MULTIPLATFORMA.png" width="100" height="56"></a> |
| ✔️ VERSIONAMENTO - COMO FAZER UPLOAD DO PROJETO ANDROID STUDIO DIRETO PARA GITHUB | <a href="https://youtu.be/xxxxxx" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BVERSIONAMENTO%5D-COMO-FAZER-UPLOAD-DO-PROJETO-ANDROID-STUDIO-DIRETO-PARA-GITHUB.png" width="100" height="56"></a> |
| ✔️ COMPOSE ON KMM - COMO ADICIONAR COMPOSE EM PROJETO KOTLIN MULTIPLATFORM MOBILE | <a href="https://youtu.be/JrEYS6dZ0vs" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCOMPOSE-ON-KMM%5D-COMO-ADICIONAR-COMPOSE-EM-PROJETO-KOTLIN-MULTIPLATFORM-MOBILE.png" width="100" height="56"></a> |
| ✔️ [CLONAR PROJETO] COMO IMPORTAR E USAR REPOSITÓRIO DO GITHUB NO ANDROID STUDIO | <a href="https://youtu.be/FE1zW68tsYQ" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCLONAR-PROJETO%5D-COMO-IMPORTAR-E-USAR-REPOSIT%C3%93RIO-DO-GITHUB-NO-ANDROID-STUDIO.png" width="100" height="56"></a> |
| ✔️ [kmm shared viewmodel] COMO COMPARTILHAR VIEWMODEL EM PROJETO KOTLIN MULTIPLATFORM | <a href="https://youtu.be/qRDjwZD-SBM" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5Bkmm-shared-viewmodel%5D-COMO-COMPARTILHAR-VIEWMODEL-EM-PROJETO-KOTLIN-MULTIPLATFORM.png" width="100" height="56"></a> |
| ✔️ [MOCKK KMM] COMO FAZER SETUP DE MOCKK EM PROJETO KOTLIN MULTIPLATFORM | <a href="https://youtu.be/h4x5isMnlJo" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BMOCKK-KMM%5D-COMO-FAZER-SETUP-DE-MOCKK-EM-PROJETO-KOTLIN-MULTIPLATFORM.png" width="100" height="56"></a> |
| ✔️ SQLDELIGHT KMM - COMO FAZER SETUP DE BANCO DE DADOS SQLDELIGHT EM PROJETO KOTLIN MULTIPLATFORM | <a href="https://youtu.be/GORjslEmbjA" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BSQLDELIGHT-KMM%5D-COMO-FAZER-SETUP-DE-BANCO-DE-DADOS-SQLDELIGHT-EM-PROJETO-KOTLIN-MULTIPLATFORM.png" width="100" height="56"></a> |
| ✔️ VIEWMODEL SQLDELIGHT - COMO ACESSAR BANCO DE DADOS NO VIEWMODEL EM PROJETO MULTIPLATFORM MOBILE | <a href="https://youtu.be/0pf_fR2Ik9M" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BVIEWMODEL-SQLDELIGHT%5D-COMO-ACESSAR-BANCO-DE-DADOS-NO-VIEWMODEL-EM-PROJETO-MULTIPLATFORM-MOBILE.png" width="100" height="56"></a> |
| ✔️ EFEITO SHIMMER - COMO CRIAR EFEITO DE SOMBRA CINTILANTE DURANTE LOADING COMPOSE | <a href="https://youtu.be/22GLg_dgwgw" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BEFEITO-SHIMMER%5D-COMO-CRIAR-EFEITO-DE-SOMBRA-CINTILANTE-DURANTE-LOADING-COMPOSE.png" width="100" height="56"></a> |
| ✔️ LOGGER KMM - COMO CRIAR LOGGER CUSTOMIZADO, COMPARTILHADO EM KOTLIN MULTIPLATFORM | <a href="https://youtu.be/ohQG-kafB7U" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BLOGGER-KMM%5D-COMO-CRIAR-LOGGER-CUSTOMIZADO-COMPARTILHADO-EM-KOTLIN-MULTIPLATFORM.png" width="100" height="56"></a> |
| ✔️ [AndroidMain] COMO CONFIGURAR PACOTE DE TESTE INSTRUMENTADO QUE USAM CONTEXTO EM KOTLIN MULTIPLATFORM | <a href="https://youtu.be/GAQbgQFngtw" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BAndroidMain%5D-COMO-CONFIGURAR-PACOTE-DE-TESTE-INSTRUMENTADO-QUE-USAM-CONTEXTO-EM-KOTLIN-MULTIPLATFORM.png" width="100" height="56"></a> |
| ✔️ BUILD TYPES KMM - COMO CRIAR BUILDTYPES E BUILDVARIANTS EM KOTLIN MULTIPLATFORM MOBILE | <a href="https://youtu.be/Wa3YaWRPlh8" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BBUILD-TYPES-KMM%5D-COMO-CRIAR-BUILDTYPES-E-BUILDVARIANTS-EM-KOTLIN-MULTIPLATFORM-MOBILE.png" width="100" height="56"></a> |
| ✔️ Environment - COMO INJETAR VARIÁVEL DE AMBIENTE EM KOTLIN MULTIPLATFORM KMM | <a href="https://youtu.be/SSxNnANQPZM" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BEnvironment%5D-COMO-INJETAR-VARI%C3%81VEL-DE-AMBIENTE-EM-KOTLIN-MULTIPLATFORM-KMM.png" width="100" height="56"></a> |
| ✔️ KTOR CLIENT HTTP - COMO CRIAR CLIENTCONFIG PARA CLIENTHTTP EM KOTLIN MULTIPLATFORM MOBILE | <a href="https://youtu.be/URTvrcRYpTM" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BKTOR-CLIENT-HTTP%5D-COMO-CRIAR-CLIENTCONFIG-PARA-CLIENTHTTP-EM-KOTLIN-MULTIPLATFORM-MOBILE.png" width="100" height="56"></a> |
| ✔️ ENDPOINTS KTOR - COMO FAZER REQUISIçÃO DE API COM KTOR EM KOTLIN MULTIPLATFORM MOBILE ANDROID | <a href="https://youtu.be/Pq8kbZxFajs" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BENDPOINTS-KTOR%5D-COMO-FAZER-REQUISI%C3%A7%C3%83O-DE-API-COM-KTOR-EM-KOTLIN-MULTIPLATFORM-MOBILE-ANDROID%20-%20Kopie.png" width="100" height="56"></a> |
| ✔️ KTOR INTERCEPTOR - COMO MAPEAR A RESPOSTA DO SERVIDOR EM CASOS DE EXCEçÃO KTOR KOTLIN KMM ANDROID | <a href="https://youtu.be/am5Ek2d5M0I" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BKTOR-INTERCEPTOR%5D-COMO-MAPEAR-A-RESPOSTA-DO-SERVIDOR-EM-CASOS-DE-EXCE%C3%A7%C3%83O-KTOR-KOTLIN-KMM-ANDROID.png" width="100" height="56"></a> |
| ✔️ VIEWMODEL FLOW - COMO CRIAR RESPOSITÓRIO QUE RETORNA FLOW PARA VIEWMODEL COM KTOR EM KOTLIN KMM | <a href="https://youtu.be/n6WKMwDTthQ" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BVIEWMODEL-FLOW%5D-COMO-CRIAR-RESPOSIT%C3%93RIO-QUE-RETORNA-FLOW-PARA-VIEWMODEL-COM-KTOR-EM-KOTLIN-KMM.png" width="100" height="56"></a> |
| ✔️ SECRET API KEYS - COMO CRIPTOGRAFAR API KEYS ANDROID EM PROJETO KOTLIN MULTIPLATFORM MOBILE | <a href="https://youtu.be/X8oEeArMnoY" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BSECRET-API-KEYS%5D-COMO-CRIPTOGRAFAR-API-KEYS-ANDROID-EM-PROJETO-KOTLIN-MULTIPLATFORM-MOBILE.png" width="100" height="56"></a> |
| ✔️ Shared BuildConfig - COMO COMPARTILHAR VARIÁVEIS DE AMBIENTE ENTRE ANDROID E IOS KMM? | <a href="https://youtu.be/Z1cpeZchpC0" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BShared-BuildConfig%5D-COMO-COMPARTILHAR-VARI%C3%81VEIS-DE-AMBIENTE-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ FIGMA ASSETS - COMO FAZER DONWLOAD DE ASSETS, IMAGENS AUTOMATICAMENTE COM SCRIPT BASH ANDROID | <a href="https://youtu.be/Vrsk2ZAedts" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BFIGMA-ASSETS%5D-COMO-FAZER-DONWLOAD-DE-ASSETS%2C-IMAGENS-AUTOMATICAMENTE-COM-SCRIPT-BASH-ANDROID.png" width="100" height="56"></a> |
| ✔️ Shared Object - COMO CRIAR BASH SCRIPT PARA GERAR CLASSE OU OBJETOS EM KOTLIN ANDROID | <a href="https://youtu.be/5q5aMna6VPU" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BShared-Object%5D-COMO-CRIAR-BASH-SCRIPT-PARA-GERAR-CLASSE-OU-OBJETOS-EM-KOTLIN-ANDROID.png" width="100" height="56"></a> |
| ✔️ Import Translation - COMO USAR BASH SCRIPT PARA IMPORTAR TEXTOS DE TRADUçÃO ANDROID | <a href="https://youtu.be/tNesvzuup3U" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BImport-Translation%5D-COMO-USAR-BASH-SCRIPT-PARA-IMPORTAR-TEXTOS-DE-TRADU%C3%A7%C3%83O-ANDROID.png" width="100" height="56"></a> |
| ✔️ Shared ImageResource - COMO COMPARTILHAR ImageResource ENTRE ANDROID E IOS KMM? | <a href="https://youtu.be/ukXx8mD9Lmo" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BShared-ImageResource%5D-COMO-COMPARTILHAR-ImageResource-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ Dependency Injection - COMO FAZER INJEçÃO DE DEPENDÊNCIAS ENTRE ANDROID E IOS KMM | <a href="https://youtu.be/VGrFCv_6bcc" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BDependency-Injection%5D-COMO-FAZER-INJE%C3%A7%C3%83O-DE-DEPEND%C3%8ANCIAS-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ Shared TextResource - COMO COMPARTILHAR StringResource ENTRE ANDROID E IOS KMM | <a href="https://youtu.be/MjitUKJFu80" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BShared-TextResource%5D-COMO-COMPARTILHAR-StringResource-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ Shared ColorResource - COMO COMPARTILHAR RECURSO DE CORES ENTRE ANDROID E IOS KMM | <a href="https://youtu.be/NtI-MWFGUBE" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BShared-ColorResource%5D-COMO-COMPARTILHAR-RECURSO-DE-CORES-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ Responsive WindowsSize - COMO DAR SUPORTE A TAMANHOS DE TELAS DIFERENTES EM ANDROID E IOS KMM | <a href="https://youtu.be/QjiN4sB5YGQ" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BResponsive-WindowsSize%5D-COMO-DAR-SUPORTE-A-TAMANHOS-DE-TELAS-DIFERENTES-EM-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ Disponibilizar Settings - COMO COMPARTILHAR SETTINGS E PREFERÊNCIAS ENTRE ANDROID E IOS KMM | <a href="https://youtu.be/FZtpWmOGYcI" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BDisponibilizar-Settings%5D-COMO-COMPARTILHAR-SETTINGS-E-PREFER%C3%8ANCIAS-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
| ✔️ Custom typography - COMO DISPONIBILIZAR TIPOGRAFIA E ESTILOS CUSTOMIZADOS EM COMPOSE | <a href="https://youtu.be/7ZGF2muCeq4" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCustom-typography%5D-COMO-DISPONIBILIZAR-TIPOGRAFIA-E-ESTILOS-CUSTOMIZADOS-EM-COMPOSE.png" width="100" height="56"></a> |
| ✔️ ColorResource - COMO DISPONIBILIZAR RECURSO DE CORES DIRETO NO MATERIAL THEME COMPOSE| <a href="https://youtu.be/kzbKuNtegkc" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BColorResource%5D-COMO-DISPONIBILIZAR-RECURSO-DE-CORES-DIRETO-NO-MATERIAL-THEME-COMPOSE.png" width="100" height="56"></a> |
| ✔️ SpacingResource - COMO DISPONIBILIZAR RECURSO DE DIMENSÃO DIRETO NO MATERIAL THEME COMPOSE | <a href="https://youtu.be/3Dy_-xtOH2k" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BSpacingResource%5D-COMO-DISPONIBILIZAR-RECURSO-DE-DIMENS%C3%83O-DIRETO-NO-MATERIAL-THEME-COMPOSE.png" width="100" height="56"></a> |
| ✔️ FontSize - COMO DISPONIBILIZAR TAMANHO DE FONTES EM UM PROJETO KOTLIN MULTIPLATAFORMA KMM | <a href="https://youtu.be/wImn7CmcMQc" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BFontSize%5D-COMO-DISPONIBILIZAR-TAMANHO-DE-FONTES-EM-UM-PROJETO-KOTLIN-MULTIPLATAFORMA-KMM.png" width="100" height="56"></a> |
| ✔️ SpacingResource - COMO USAR RECURSO DE DIMENSÃO COMPARTILHADO NO SPACER ANDROID COMPOSE KMM | <a href="https://youtu.be/luxthMWcxOU" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCustom-Spacer%5D-COMO-USAR-RECURSO-DE-DIMENS%C3%83O-COMPARTILHADO-NO-SPACER-ANDROID-COMPOSE-KMM.png" width="100" height="56"></a> |
| ✔️ ListView Item - COMO CRIAR LIST VIEW ITEM CUSTOMIZADO COMPOSE KOTLIN MULTIPLATAFORMA KMM | <a href="https://youtu.be/7nyVh7mKN88" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BListView%5D-COMO-CRIAR-LIST-VIEW-ITEM-CUSTOMIZADO-COMPOSE-KOTLIN-MULTIPLATAFORMA-KMM.png" width="100" height="56"></a> |
| ✔️ Custom Button - COMO CRIAR BOTÕES CUSTOMIZADOS PARA ANDROID COMPOSE KMM | <a href="https://youtu.be/qKwn8Xu2Tlk" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCustom-Button%5D-COMO-CRIAR-SET-DE-BOT%C3%95ES-CUSTOMIZADOS-PARA-ANDROID-COMPOSE-KMM.png" width="100" height="56"></a> |
| ✔️ DimensResource - COMO COMPARTILHAR ALTURA E LARGURA DOS COMPONENTES ENTRE ANDROID E IOS KMM? | <a href="https://youtu.be/NXOL-F3IGIQ" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BDimensResource%5D-COMO-COMPARTILHAR-ALTURA-E-LARGURA-DOS-COMPONENTES-ENTRE-ANDROID-E-IOS-KMM.png" width="100" height="56"></a> |
|⚡ PROGUARD - COMO OFUSCAR, DEPURAR, OTIMIZAR E REDUZIR TAMANHO DO CÓDIGO COM PROGUARD ANDROID? | <a href="https://youtu.be/UaYT-G_80wg" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BPROGUARD%5D-COMO-OFUSCAR-DEPURAR-OTIMIZAR-E-REDUZIR-TAMANHO-DO-C%C3%93DIGO-COM-PROGUARD-ANDROID.png" width="100" height="56"></a> |
| ✔️ CUSTOM TEXTFIELD - COMO CRIAR E VERIFICAR ENTRADAS EM CAMPOS DE TEXTO ANDROID COMPOSE? | <a href="https://youtu.be/uXpBj7yRHF8" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCUSTOM-TEXTFIELD%5D-COMO-CRIAR-E-VERIFICAR-ENTRADAS-EM-CAMPOS-DE-TEXTO-ANDROID-COMPOSE.png" width="100" height="56"></a> |
| ✔️ LOADING BUTTON - COMO FAZER ANIMAçÃO DE LOADING EM BOTÃO COM LOTTIE ANIMATION ANDROID COMPOSE? | <a href="https://youtu.be/DKucCs2dJyM" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BLOADING-BUTTON%5D-COMO-FAZER-ANIMA%C3%A7%C3%83O-DE-LOADING-EM-BOT%C3%83O-COM-LOTTIE-ANIMATION-ANDROID-COMPOSE.png" width="100" height="56"></a> |
| ✔️ CUSTOM DIALOGS - COMO CRIAR ALERT DIALOG PERSONALIZADO EM JETPACK COMPOSE ANDROID? | <a href="https://youtu.be/8zdwUFZxOB8" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCUSTOM-DIALOGS%5D-COMO-CRIAR-ALERT-DIALOG-PERSONALIZADO-EM-JETPACK-COMPOSE-ANDROID.png" width="100" height="56"></a> |
| ✔️ CUSTOM BOTTOMSHEET - COMO IMPLEMENTAR MODAL BOTTOMSHEET CUSTOMIZADO EM JETPACK COMPOSE? | <a href="https://youtu.be/IacSihEyQms" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BCUSTOM-BOTTOMSHEET%5D-COMO-IMPLEMENTAR-MODAL-BOTTOMSHEET-CUSTOMIZADO-EM-JETPACK-COMPOSE.png" width="100" height="56"></a> |
| **🚩 AGENDADO: 09/03/2023** ✔️ USABILIDADE - COMO TRATAR TEXTOS E FONTES GIGANTES EM APARELHOS PEQUENOS JETPACK COMPOSE? | <a href="https://youtu.be/MOKUs3fsTCo" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BUSABILIDADE%5D-COMO-TRATAR-TEXTOS-E-FONTES-GIGANTES-EM-APARELHOS-PEQUENOS-JETPACK-COMPOSE-ANDROID.png" width="100" height="56"></a> |
| **🚩 AGENDADO: 13/03/2023** ✔️ ONLINE/OFFLINE - COMO MONITORAR E EXIBIR MENSAGEM DE CONECTIVIDADE EM JETPACK COMPOSE? | <a href="https://youtu.be/w7dbyXGfsco" target="_blank"><img src="https://github.com/treslines/android_compose_arsenal/blob/main/app/src/main/mini/%5BONLINEOFFLINE%5D-COMO-MONITORAR-E-EXIBIR-MENSAGEM-DE-CONECTIVIDADE-EM-JETPACK-COMPOSE.png" width="100" height="56"></a> |

# Ta Curtindo? 
Algum dos meus vídeos, posts ou repositórios te salvou muito tempo ou te ajudou no trabalho? Não é clichê não, eu produzo mais com café mesmo. 😁 É minha gasolina ⛽️ Me presentea com um café aqui: https://bit.ly/umCafeGb

#### Caso não possa, me deixa ao menos uma estrelinha ⭐ aqui no repositório. Obrigado pelo suporte. 😎🤜🤛
![image](https://user-images.githubusercontent.com/1042887/170558597-8ff115e4-58f1-445e-9125-422729a67a22.png)

# Quer fazer networking, mas não sabe como? 
**Telegram**: Entra no nosso do telegram para um contato mais rápido e direto: https://bit.ly/telegramGb
![image](https://user-images.githubusercontent.com/1042887/169701787-dba72b6f-c5b7-4d34-9d51-0052a7b40443.png)
 
**Discord**: Networking, vagas, livros e muito muito conhecimento compartilhado: https://bit.ly/discordGb 

![image](https://user-images.githubusercontent.com/1042887/170555025-9b0b3d83-ca7a-468d-86b9-c4d40deb9775.png)

# Techblog BugOnSoftware
Você prefere um conteúdo por escrito de **alta qualidade** e **extremamente didático** em Português? Da uma olhada aqui: https://bit.ly/techblogGb 
![image](https://user-images.githubusercontent.com/1042887/170555703-f4323c08-2bda-43a1-b42e-37d8fb7463b9.png)

# ⛓️ CONECTE-SE COMIGO
- 🧲 | Telegram: networking gratuito ► https://bit.ly/telegramGb
- 🧲 | Discord: conteúdo seleto ►  https://bit.ly/discordGb
- 🧲 | Techblog: system design ► https://bit.ly/techblogGb
- 🧲 | Twitter: posts semanais ►  https://bit.ly/twitterGb
- 🧲 | Tiktok: dicas e resenha ►  https://bit.ly/tiktokGb
- 🧲 | LinkedIn: seja encontrado por recrutadores ► https://bit.ly/linkedinGb
- 🧲 | Github: deixa uma estrelinha ► https://github.com/treslines

---

### ⚽ **OUTROS REPOSITÓRIOS QUE VOCÊ VAI CURTIR MUITO:**
🇧🇷 **Almanac do Desenvolvedor Profissional Android** 🇵🇹 
</br>
<a href="https://github.com/treslines/desafios_comuns_android" target="_blank"> 👉 **DESAFIOS E PROBLEMAS COMUNS NA VIDA DO DESENVOLVEDOR ANDROID**</a>
</br>
<a href="https://github.com/treslines/aad" target="_blank"> 👉 **GOOGLE DEVELOPER CERTIFICATION**</a>
</br>
<a href="https://github.com/treslines/android_compose_arsenal" target="_blank"> 👉 **JETPACK COMPOSE ARSENAL** </a>
</br> 
