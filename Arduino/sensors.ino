#include <ESP8266WiFi.h>
#include <FirebaseESP8266.h>

#ifndef STASSID
#define STASSID "SUPER"
#define STAPSK  "wp1wp2wp3"
#endif

#define pin_lm35 A0 //Pino o qual o sensor está conectado

const char* ssid     = STASSID;
const char* password = STAPSK;


const char* host = "https://monitore-eb7ae-default-rtdb.firebaseio.com/";
const char* token = "whFHSuZugKJgmV5pQtGJ39FDVpcWEsn8JqtEFtyQ";

FirebaseData minhaBase;
bool statusConexao = false;

void setup() {
  // put your setup code here, to run once:
Serial.begin(9600);
pinMode(pin_lm35, INPUT); // Define o sensor como uma entrada de sinal
pinMode(2,OUTPUT);
WiFi.begin(ssid,password);

while (WiFi.status()!=WL_CONNECTED){
  delay(5000);
}
//statusConexao =true;
Firebase.begin(host,token);
}

void loop() {

  
//Codigo do Sensor de luminosidade
  int sensorValue = analogRead(A0);   // Ler o pino Anal贸gico A0 onde est谩 o LDR
  int voltagem = sensorValue; //(3.3 / 1024.0);/   // Converter a leitura anal贸gica (que vai de 0 - 1023) para uma voltagem (0 - 3.3V), quanto de acordo com a intensidade de luz no LDR a voltagem diminui.
  Serial.println(voltagem);   // Mostrar valor da voltagem no monitor serial
  Firebase.setInt(minhaBase, "Teste", voltagem); //Envia o dado da variavel voltagem para a variavel Teste no Firebase
  delay(500); // Espera 5 segundos 
  
  /* 
Firebase.get(minhaBase, "teste");
int led = minhaBase.intData();

switch(led){
  case led < 500:
  digitalWrite(2,LOW);
  break;

  case led > 500:
  digitalWrite(2,HIGH);
  break;

  

  //Codigo do LM35
  /*float valor_analog_lm35 = float(analogRead(pin_lm35)); // Obtém o valor analógico que varia de 0 a 1023
  float tensao = (valor_analog_lm35 * 5) / 1023; // Vamos converter esse valor para tensão elétrica
  float temperatura = tensao / 0.010; // dividimos a tensão por 0.010 que representa os 10 mV
  int temp = temperatura;
  Firebase.setInt(minhaBase, "Teste", temperatura);
  delay(1000);*/
  }
