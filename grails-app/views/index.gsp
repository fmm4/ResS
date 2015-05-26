<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>ResS</title>
		<type="text/css" media="screen">
		<style>
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}



			h2 {

				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}



			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {

					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>

		<div id="status" role="complementary">
			<h1>Menu</h1>
			<ul>
				<li><g:link controller="ResidueGenerator">Geradores de Residuo</g:link></li>
				<li><g:link controller="ResidueCollector">Coletores de Residuo</g:link></li>
				<li><a href="dev.gsp">Desenvolvedores</a></li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Bem-vindo ao ResS</h1>
			<p>O ResS é um sistema feito para auxiliar no gerênciamento e armazenamento de informações relacionadas à coleta de residuos de óleo reusáveis. Inicialmente este sistema
			têm como foco o campus UFPE, usando geradores como o Restaurante Universitário. Com o ResS você pode criar e manusear pontos de Geradores de Residuo e Coletores,
			gerar rotas para estes pontos, agendar coletas e ver a produção diária e mensal dos geradores.</p>
		</div>
	</body>
</html>
