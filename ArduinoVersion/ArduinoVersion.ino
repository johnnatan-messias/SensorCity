float temp = 0;
float light = 0;

int analTempPin = A5;
int analLightPin = A2;
int digBuzzerPin = 7;

void setup(){
  Serial.begin(9600);
  pinMode(digBuzzerPin, OUTPUT);
}

void loop(){

  temp = analogRead(analTempPin);
  light = analogRead(analLightPin);
  if(light < 400)
    digitalWrite(digBuzzerPin, HIGH);
   else
       digitalWrite(digBuzzerPin, LOW);
   
  temp = (5.0 * temp * 100.0)/1024.0;
  light = map(light, 0, 1023, 0, 100);
 // temp*=0.48828125;
  Serial.print("1");
  Serial.print(";");
  Serial.print("1");
  Serial.print(";");
  Serial.print("1");
  Serial.print(";");
  Serial.print(temp);
  Serial.print(";");
  Serial.println(light);
  

  delay(5000);
  
}
