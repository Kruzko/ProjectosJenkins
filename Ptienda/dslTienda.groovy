// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda del Corte Ingles')
    scm {
        git('https://github.com/Kruzko/ProyectoTienda', 'master'){ 
            node -> 
                node / gitConfigName('Kruzko')
                node / gitConfigEmail('hermanomayor2@gmail.com')
        }
    }
    triggers {
     //   scm('H/5 * * * *')
        githubPush()
    }
    
    steps {
        shell('bash install.sh')
    }
}