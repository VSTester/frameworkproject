from selenium.webdriver.common.by import By
from utilities.Utility import Utility

class LoginPage:
    textbox_username_name= "user_name"
    textbox_password_name="user_password"
    button_login_xpath="//input[@title='Login [Alt+L]']"



    def __init__(self, driver):
        self.driver = driver
        self.util = Utility(self.driver)




    def enterUserName(self,userName):
        inputUserName =self.driver.find_element(By.NAME,self.textbox_username_name)
        self.util.enterData(inputUserName,userName,self.textbox_username_name)
        print("Enter data in :", self.textbox_username_name)

    def enterPassword(self,password):
        inputPassword = self.driver.find_element(By.NAME, self.textbox_password_name)
        self.util.enterData(inputPassword,password,self.textbox_password_name)
        print("Enter data in :", self.textbox_password_name)


    def clickOnLoginBtn(self):
        loginBtn = self.driver.find_element(By.XPATH, self.button_login_xpath)
        self.util.clickOnElement(loginBtn,self.button_login_xpath)
        print("Click on Login button successfully")
