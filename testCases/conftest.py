import pytest
from selenium import webdriver
from utilities.Utility import Utility




@pytest.fixture
def setup(browser):
    global driver
    try:
       if browser == "chrome":
         driver = webdriver.Chrome(executable_path="C:\\Users\\dell\\PycharmProjects\\demoProject\\drivers\\chromedriver.exe")
       elif browser== "firefox":
         driver = webdriver.Firefox(executable_path="C:\\Users\\dell\\Downloads\\geckodriver-v0.31.0-win64\\geckoDriver.exe")
       else:
         driver = webdriver.Chrome(executable_path="C:\\Users\\dell\\PycharmProjects\\demoProject\\drivers\\chromedriver.exe")
       util = Utility (driver)
       driver.get ( util.getDataFromConfig ( "base_Url" ))
       driver.maximize_window ( )
       driver.implicitly_wait ( 45 )
    except:
        print("Browser is getting")
    return driver


def pytest_addoption(parser):
    parser.addoption("--browser")


@pytest.fixture()
def browser(request):
    return request.config.getoption("--browser")




################  Pytest HTML REPORT ###################

def pytest_configure(config):
    config._metadata['Project Name']= 'Vtiger CRM'
    config._metadata['Domain Name'] = 'E-Commerce'
    config._metadata['OS'] = 'Window'
    config._metadata['Tester Name'] = 'Krish'



####   It is hook for delete/modify enviroment info to HTML Report ########

@pytest.mark.optinalhook
def pytest_metadata(metadata):
    metadata.pop("JAVA_HOME",None)
    metadata.pop("Plugins",None)

