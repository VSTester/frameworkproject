import time

import allure
import pytest
from allure_commons.types import AttachmentType

from pageObjects.LoginPage import LoginPage
from utilities.Utility import Utility
from utilities.customLogger import LogGen

@allure.severity(allure.severity_level.NORMAL)
class TestLogin:
    global util
    logger=LogGen.loggen()

    @allure.severity (allure.severity_level.MINOR)
    def test_validateLoginPageTitle( self,setup ):
            self.logger.info("setUp Start for test cases")
            self.driver = setup
            # Below COmmented code inside the setUp function in conftest.py
            # self.driver = webdriver.Chrome ( "C:\\Users\\dell\\PycharmProjects\\demoProject\\drivers\\chromedriver.exe" )
            # self.driver.get(self.base_Url)
            # self.driver.maximize_window()
            # self.driver.implicitly_wait(45)
            act_LoginPageTile = self.driver.title
            if act_LoginPageTile == "vtiger CRM 5 - Commercial Open Source CRM":
                self.driver.close ()
                assert True
                print("title is : ",act_LoginPageTile)
            else:
                time.sleep(9)
                allure.attach(self.driver.get_screenshot_as_png(),name="ValidateLoginTitle",
                              attachment_type=AttachmentType.PNG)
                self.driver.save_screenshot("C:\\Users\\dell\\PycharmProjects\\VtigerAutomation\\Screenshots\\"+"test_validateHomePageTitle.png")
                self.driver.close()
                assert  False

    @allure.severity ( allure.severity_level.NORMAL )
    def test_ValidateValidLogin( self, setup):
            self.driver = setup
            # self.driver.get(self.base_Url)
            # self.driver.maximize_window()
            # self.driver.implicitly_wait(45)
            self.util = Utility(self.driver)
            self.loginPage_Obj = LoginPage(self.driver)
            self.loginPage_Obj.enterUserName(self.util.getDataFromConfig("userName"))
            self.loginPage_Obj.enterPassword(self.util.getDataFromConfig("password"))
            self.loginPage_Obj.clickOnLoginBtn()
            time.sleep(4)
            act_HomePageTile = self.driver.title
            if act_HomePageTile.__contains__("admin - My Home Page - Home"):
                 self.driver.close()
                 assert True
            else:
                time.sleep ( 9 )
                self.driver.save_screenshot (
                    "C:\\Users\\dell\\PycharmProjects\\VtigerAutomation\\Screenshots\\" + "test_ValidateValidLogin.png" )
                self.driver.close ()
                assert  False






