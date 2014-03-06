#!/usr/bin/env groovy

groovy.grape.Grape.grab([group:'org.gebish', module:'geb-core', version:'0.9.2'])
groovy.grape.Grape.grab([group:'org.seleniumhq.selenium', module:'selenium-chrome-driver', version:'2.37.1'])
groovy.grape.Grape.grab([group:'org.seleniumhq.selenium', module:'selenium-support', version:'2.37.1'])
 
d=new org.openqa.selenium.chrome.ChromeDriver()
d.navigate().to 'http://hadoopsummit.org/amsterdam/schedule'

plist=d.findElementsByClassName('positioner')

tracks=[]

plist.each{trackDiv ->
  trackName='none'
  trackSpeaker='none'
  trackType='none'
  trackText='non'

  try {
   nameTag=trackDiv.findElement(new org.openqa.selenium.By.ByClassName('sess_name'))
   nameTag.click()
   trackName=nameTag.text
  } catch(Exception e) {}

  paragTag=trackDiv.findElement(new org.openqa.selenium.By.ByTagName('p'))

  try {
   coloTagr=trackDiv.findElement(new org.openqa.selenium.By.ByClassName('track_color'))
   trackType=coloTagr.getAttribute('class').split(' ').find{'track_color' != it}
  } catch(Exception e) {}


  try {
   speakerTag=trackDiv.findElement(new org.openqa.selenium.By.ByClassName('sess_speaker_name'))
   trackSpeaker=speakerTag.text
  } catch(Exception e) {}

  trackText=paragTag.text

  tracks<< [type: trackType, title:trackName, speaker:trackSpeaker, description: trackText]
  
  closebtn=trackDiv.findElement(new org.openqa.selenium.By.ByClassName('closebtn'))
  closebtn.click()
}

json = new groovy.json.JsonBuilder()
json tracks

file = new File("summit.json")
file << json.toString()