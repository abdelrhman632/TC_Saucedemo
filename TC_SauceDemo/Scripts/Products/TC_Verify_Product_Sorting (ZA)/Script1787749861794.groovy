import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('Page_Swag Labs/input_Username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Page_Swag Labs/input_Password'), 'qcu24s4901FyWDTwXGr6XA==')

WebUI.sendKeys(findTestObject('Page_Swag Labs/input_Password'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low to h'), 'za', false)

def products = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/Product_Names'), 10)

println('Number of products found: ' + products.size())

products.each({ def product ->
        println(product.getText())
    })

def productNames = products.collect({ 
        it.getText().trim()
    })

def sortedProductNames = productNames.toList().sort(Collections.reverseOrder())

println('Actual order:')

productNames.each({ 
        println(it)
    })

println('Expected alphabetical order:')

sortedProductNames.each({ 
        println(it)
    })

println('Actual list: ' + productNames)

println('Expected list: ' + sortedProductNames)

println('Lists equal: ' + (productNames == sortedProductNames))

assert productNames !== sortedProductNames : 'Products are NOT sorted alphabetically'

if (productNames == sortedProductNames) {
    println('Products ARE sorted alphabetically')
} else {
    println('Products are NOT sorted alphabetically')
}

