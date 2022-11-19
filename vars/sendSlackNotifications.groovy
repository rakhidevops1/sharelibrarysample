def sendslacknotifications(String buildStatus = 'STARTED') {
      // build status of null means successful
      buildStatus =  buildStatus ?: 'SUCCESS'
    
      // Default values
      def colorName = 'RED'
      def colorCode = '#FF0000'
      def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
      def summary = "${subject} (${env.BUILD_URL})"
    
      // Override default values based on build status
      if (buildStatus == 'STARTED') {
        colorName = 'YELLOW'
        colorCode = '#FFFF00'
      }else if (buildStatus == 'CLONING') {
        colorName = 'BLUE'
        colorCode = '#0B1CEC'
      }else if (buildStatus == 'BUILDINGWARPACKAGE') {
        colorName = 'ORANGE'
        colorCode = '#F6990B'
      }else if (buildStatus == 'RUNNINGSONAR') {
        colorName = 'CYAN'
        colorCode = '#0EF6C8'
      }else if (buildStatus == 'UPLOADINGARTIFACTS') {
        colorName = 'DARKGREEN'
        colorCode = '#3B9119'
      }else if (buildStatus == 'DEPLOYINGTOTOMCAT') {
        colorName = 'PINK'
        colorCode = '#EC0AE1'
      }else if (buildStatus == 'SUCCESS') {
        colorName = 'GREEN'
        colorCode = '#00FF00'
      } else {
        colorName = 'RED'
        colorCode = '#FF0000'
      }
    
      // Send notifications
      slackSend (color: colorCode, message: summary, channel: "#walmart-dev")
    }