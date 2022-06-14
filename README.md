![da-android-todoc](https://user-images.githubusercontent.com/78255467/173357715-1ad86980-02b2-422b-bbbc-eb0f2675eff9.svg)
![#p5-openclassrooms](https://user-images.githubusercontent.com/78255467/173357720-3ac4bc43-6870-4232-a035-de1ba8df577b.svg)

# VERSION FRANCAISE
(English translation in the 2nd part of the documentation below)

# Todoc

Ce dépôt contient une mini-application pour le P5 du parcours **DA ANDROID**, intitulée **Todoc**, réalisée pour *Cleanup*,  
entreprise de nettoyage de locaux commerciaux.
L'application ici développée permet ainsi aux collaborateurs de l'entreprise d'obtenir une vision précise des tâches à accomplir, 
lorsqu'ils se rendent dans les locaux à nettoyer.

## Technologies
- 100% JAVA, ce projet a été réalisé à partir de l'IDE Android Studio.

## Installation
- Ouvrez votre IDE préféré (ici Android Studio)
- Ouvrez un nouveau projet et choississez "Get From Version Control"
- Clonez l'application en copiant / collant ce lien : https://github.com/benlinux1/DA_ANDROID_TODOC
- Spécifiez un dossier de destination sur votre ordinateur et cliquez sur "clone"
- Voici les étapes en images :

![GIT OK README](https://user-images.githubusercontent.com/78255467/173385204-cf85b735-5d75-4cab-8fa1-427ee70b3240.png)

L'application va ensuite se compiler dans Android Studio

## Utilisation / Lancement de l'application

Vous pouvez utiliser cette application via un émulateur, pour une simulation sur le mobile de votre choix.
Pour ce faire, rendez-vous dans le ruban à droite de la fenêtre puis "create device" et laissez-vous guider.

Vous pouvez également utiliser cette application sur votre smartphone personnel en choississant l'option "physical"
Ensuite, lancez l'application en cliquant sur le bouton triangulaire "Run", comme ci-dessous :

![Sans titre-2](https://user-images.githubusercontent.com/78255467/163193524-89842086-ca39-475c-afc2-e39e3e586f68.png)

## Fonctionnalités

Cette applcation vous permet de/d' :

- Afficher la liste des tâches planifiées parmi les 3 projets en cours, chaque projet étant identifiable par une couleur unique.
- Ajouter une nouvelle tâche, après l'avoir assignée à l'un des 3 projets existants.
- Supprimer la/les tâches de votre choix, dans la liste générale.
- Trier les tâches dans la liste générale, par ordre alphabétique (ou inversement) ou par date de création (chronologiquement ou de la plus récente à la plus ancienne).

![Fonctionnalités FR](https://user-images.githubusercontent.com/78255467/173392991-e153774d-e9ca-4953-88d4-c8ce81fc9f17.png)

## Architecture Components & persistence des données

L'application adopte l'Architecture Components et gère la persistance des données, à partir d'une base de données SQLite Room.
Chaque tâche appartenant à un projet, la base de données contient actuellement 2 tables ("tâches" et "projets").
Comme le décrit le schéma ci-dessous, l'ensemble des données est manipulable grâce aux DAO (Data Access Object). Les repositories dédiés permettent de récupérer les données des Dao, puis grâce à leurs méthodes publiques, d'afficher les données dans la MainActivity par l'intermédiaire d'un ViewModel pour chaque tâche.

<p align="center">
  <img width="533" alt="Architecture ok" src="https://user-images.githubusercontent.com/78255467/173401218-ad4cac28-de55-4f5a-bc06-b3df8124d244.png">
</p>

## Tests

L'application a été testée par émulation sur les appareils suivants :

**Smartphones** :

- Pixel 3XL (API 30)
- Pixel 5 (API 30)
- Nexus 6 (API 30)
- Nexus S (API 30)

**Tablettes** :

- Nexus 9 (API 30)
- Nexus 10 (API 30)
- Pixel C (API 30)

Elle a également été testée dans des conditions réelles, sur un smartphone physique Samsung Galaxy S20 et sur une tablette Samsung Galaxy A7.

## Contribuez au projet

Todoc est un projet open source. Vous pouvez donc en utiliser le code source à votre guise pour développer vos propres fonctionnalités.

## Auteurs

Notre équipe : BenLinux & FranckBlack


============================================================================================

![da-android-todoc](https://user-images.githubusercontent.com/78255467/173360674-649d0829-c367-4908-b9e9-c8c394050a5b.svg)
![#p5-openclassrooms](https://user-images.githubusercontent.com/78255467/173360692-faa9b034-07ad-4f4a-b9ce-54e27e8bd15c.svg)

# ENGLISH VERSION
(version française en 1ère partie de la documentation)

# Todoc

This repository contains a mini app for the **DA Android** 5th projet, untitled **Todoc**, created for *Cleanup*, a cleaning company in commercial or office spaces.

## Technologies
- 100% JAVA, this project was made with Android Studio IDE.

## Install
- Open your favorite IDE (here Android Studio)
- Open a new project and choose "Get From Version Control" option
- Clone the app by copying / pasting this repository link : https://github.com/benlinux1/DA_ANDROID_TODOC.git
- Specify a destination folder name on your computer and click "clone"
- Here are the steps to illustrate in pictures :

![GIT OK README](https://user-images.githubusercontent.com/78255467/173385204-cf85b735-5d75-4cab-8fa1-427ee70b3240.png)

Next the app will compile in Android Studio

## Use / How to launch app

You can use this app with an emulator, for a choosen mobile simulation.
To do that, go to the tools ribbon in the right part of the window and click "create device". Then, follow the instructions on screen.

You can also use this app with your own smartphone, choosing "physical" option in device manager, 
Then, launch app clicking on the green triangle button "Run", like in this example :

![Sans titre-2](https://user-images.githubusercontent.com/78255467/163193524-89842086-ca39-475c-afc2-e39e3e586f68.png)

## Features

This app allow you to :

- Display global tasks list
- Add a new task, after you hav assigned it to one of three existing projects.
- Delete a task from global list
- Sort all tasks alphabetically or by date. Each sorting method can be inverted (A to Z, Z to A, old first, recent first).

![Fonctionnalités GB](https://user-images.githubusercontent.com/78255467/173393086-93a82a68-7b9c-4b84-bee1-0cb62e81501a.png)

## Architecture Components & Data persistence

This app adopt Architecture Components and provides data persistence, thanks to SQLite Room.
Each task belongs to a project, so this database contains currently 2 tables ("tasks" & "projects").
As describes the picture below, data is accessed by DAO (Data Access Object). The two dedicated repositories provides access to Dao data, then thanks to their public methods, display data in MainActivity through a ViewModel for each task.

<p align="center">
  <img width="533" alt="Architecture ok" src="https://user-images.githubusercontent.com/78255467/173401218-ad4cac28-de55-4f5a-bc06-b3df8124d244.png">
</p>

## Tests

This app has been tested on following devices :

**Smartphones** :

- Pixel 3XL (API 30)
- Pixel 5 (API 30)
- Nexus 6 (API 30)
- Nexus S (API 30)

**Tabs** :

- Nexus 9 (API 30)
- Nexus 10 (API 30)
- Pixel C (API 30)

It was also tested in real conditions, on a physical smartphone device Samsung Galaxy S20, and a physical tab device Samsung Galaxy A7.

## Contribute to the project

Todoc is an open source project. Feel free to fork the source and contribute with your own features.

## Authors

Our code squad : BenLinux & FranckBlack
