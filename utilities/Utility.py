from jproperties import Properties

class Utility:

    def __init__(self,driver):
        self.driver = driver




    def loadConfigFile(self):
        self.config = Properties ( )
        with open ( "C:\\Users\\dell\\PycharmProjects\\VtigerAutomation\\Configurations\\config.properties",
                    'rb' ) as config_file:
            self.config.load (config_file)
            print (self.config.get("browser").data)

    def getDataFromConfig(self,testData):
        self.config = Properties ( )
        with open ( "C:\\Users\\dell\\PycharmProjects\\VtigerAutomation\\Configurations\\config.properties",
                    'rb' ) as config_file:
            self.config.load ( config_file )
        testValue = self.config.get(testData).data
        return testValue


    def openApplication(self,applicationUrl):
        try:
         self.driver.get(applicationUrl)
         print("Hit Application Url Successfully")
        except:
            print("Something went wrong in the process of hitting application Url")

    def clickOnElement(self,element,filedLocator):
        try:
         element.click()
         print("click on element sucessfully: ",filedLocator)
        except:
            print("Unable to click on elemnt: ", filedLocator)


    def enterData(self,element,value,filedLocator):
        try:
         element.clear()
         element.send_keys(value)
         print("Enter data in element sucessfully: ",filedLocator)
        except:
            print("Unable to Enter data in elment: ", filedLocator)


