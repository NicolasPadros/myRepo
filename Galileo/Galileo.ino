const int mic1 = 2;
const int mic2 = 7;


const int led1 = 3;
const int led2 = 5;

int value = 0;
int value2 = 0;
bool state1 = true;
bool state2 = true;
int maxVolume;

void setup() {
 Serial.begin(9600);
 pinMode(mic1, INPUT);
 pinMode(led1, OUTPUT);
 pinMode(mic2, INPUT);
 pinMode(led2, OUTPUT);
}

void loop() {
 value = digitalRead(mic1);
 value2 = digitalRead(mic2);
 Serial.println(value2);
 if(value == 1){
  state1 =  !state1;
  Serial.println(state1);
  digitalWrite(led1, state1);
  delay(1000);
 }
   if(value2 == 1){
  state2 =  !state2;
  Serial.println(state2);
  digitalWrite(led2, state2);
  delay(1000);
   } else {
 delay(10);
}
 }

int getMaxVolumeMic(){
    
}

/*

Upload the code to the Intel Galileo and open the Serial Monitor to observe what values
we receive.
If the circuit is correct, you should receive a stable value of some sort. Rubbing or
tapping on the microphone should raise the values but talking or clapping to the
microphone might not give you the results you want because of the delay in our main
loop.
Testing Claps
We will test the clapping threshold by replacing the main loop code with the following:
void loop() {
 value = analogRead(mic);

 if(value > threshold){
 Serial.println(value);
 }
}
Where ‘threshold’ is a variable that is a number approximately 20+ of the stable value.
This variable should be tested and set towards whichever best detects your claps.
Notice: For every clap, you’ll receive multiple print statements. Adding a delay(100)
inside the if statement will help reduce the multiple prints and can possibly also help with
the exercises
*/
