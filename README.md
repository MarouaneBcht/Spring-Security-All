<h1>
Patient App (Spring Security)</h1>

<br>
Spring Security types in this project : <br>
<h6>- InMemoryAuthentication</h6>
<h6>- JDBC Authentication </h6>
<h6>- UserDetailsService Authentication </h6>
----------------------------------------------------------------------------------------------------------------------
<br>

## 1) InMemoryAuthentication

<h4>Login page</h4>

<img src="Caps/1.PNG">

<br>


<h4>SecurityConfig.java</h4>

<img src="Caps/SecConfig.PNG">

<br>
<h4>SecurityController.java</h4>

<img src="Caps/secController.PNG">

<br>

<h4>Login.html</h4>

<img src="Caps/loginHtml.PNG">

<br>
<h4>notAuthorized page</h4>

<img src="Caps/notAuthorized.PNG">

<br>
<h4>notAuthorized.html</h4>

<img src="Caps/notAuthorized.html.PNG">

<hr>

## 2) JDBC Authentication


<h4>SecurityConfigJDBC.java</h4>

<img src="Caps/jdbcConfig.PNG">

<br>

<h4>application.properties</h4>


<img src="Caps/prop.PNG">

<br>

Pour créer (users and authorities) dans notre base de données nous allons créer un fichier "schema.sql"

<h4>schema.sql</h4>

<img src="Caps/schemaSql.PNG">

<br>

Création des utilisateurs et définir les roles

<img src="Caps/commandLine.PNG">

<br>
Nous allons utiliser un controlleur pour la gestion des paths de "login" et "notAuthorized"
<h4>SecurityController.java</h4>

<img src="Caps/secController2.PNG" >

<br>
<h4>Login.html</h4>

<img src="Caps/loginHtml.PNG" >

<br>
<h4>notAuthorized page</h4>

<img src="Caps/notAuthorized.PNG">

<br>
Lorsqu'on demarre l'application nous avons la page "login"
<h4>1- Login page</h4>

<img src="Caps/1.PNG" >

<br>

## 3) UserDetailsService Authentication

<br>
Pour UserDetailsService Authentication nous devrons ajouter les packages: "entities, repositories et services"

<img src="Caps/packages.PNG">

<br>

Pour AppUser:

<h4>AppUser.java</h4>

<img src="Caps/AppUser.PNG">

<br>

<h4>AppUserRepository.java</h4>

<img src="Caps/AppUserRep.PNG">


<br>

Pour AppRole:

<h4>AppRole.java</h4>

<img src="Caps/AppRole.PNG">

<br>

<h4>AppRoleRepository.java</h4>

<img src="Caps/AppRoleRep.PNG">

<br>

Pour les services:

<h4>AccountService.java</h4>

<img src="Caps/accService.PNG">

<br>

L'implementation des services :

<img src="Caps/impl1.PNG">

<img src="Caps/impl2.PNG">


<br>

<h4>UserDetailsServiceImpl.java</h4>

<img src="Caps/userImpl.PNG">

<br>

Pour Security Config nous allons utiliser passwordEncoder et SecurityFilterChain et l'injection de userDetailsServiceImpl de type UserDetailsServiceImpl:

<h4>SecurityConfigUser.java</h4>

<img src="Caps/SecConfigUser.PNG">

<br>

Définir les roles ou les autorisations:
<h4>PatientController.java</h4>

<img src="Caps/patientController.PNG">

<br>

Test:

<h4>CommandLineRunnerUserDetails</h4>

<img src="Caps/commandLineUser.PNG">

<br>

<h4>SecurityRestController.java</h4>

<img src="Caps/secRest.PNG">

<br>

Message d'erreur pour les tentatives d'authentification échouées:

<h4>login.html</h4>

<img src="Caps/errorMsg.PNG">
