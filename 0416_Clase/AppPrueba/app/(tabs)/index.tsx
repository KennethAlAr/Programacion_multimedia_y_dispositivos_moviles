import { View, Text, Button, StyleSheet, TextInput } from "react-native";
import { useState } from "react";


export default function App(){

  const [nombre, setNombre] = useState('')
  const [apellido, setApellido] = useState('')
  const [saludo, setSaludo] = useState('¡Hola! Introduce tu nombre y apellido.')

  //const [contador, setContador] = useState(0)

  /*return(
    <View style={styles.container}>
      <Text style={styles.texto}>Contador: {contador}</Text>
      <Button
        title="Sumar"
        onPress={() => setContador(contador +1)}
      />
      <Button
        title="Restar"
        onPress={() => setContador(contador -1)}
      />
    </View>
  );*/

  return(
    <View style={styles.container}>
      <Text style={styles.titulo}>Escribe tu nombre:</Text>
      <TextInput
        style={styles.input}
        placeholder="Tu nombre"
        value={nombre}
        onChangeText={setNombre}
      />
      <Text style={styles.titulo}>Escribe tu apellido:</Text>
      <TextInput
        style={styles.input}
        placeholder="Tu apellido"
        value={apellido}
        onChangeText={setApellido}
      />
      <Button
        title="saludar"
        onPress={()=> {
          if(nombre.length > 5){
            setSaludo(`Hola ${nombre.toUpperCase()} ${apellido.toUpperCase()}, tienes un nombre muy largo.`);
          } else if (nombre.length == 0 && apellido.length == 0) {
            setSaludo(`¡Hola! Introduce tu nombre y apellido.`);
          } else {
            setSaludo(`Hola ${nombre.toUpperCase()} ${apellido.toUpperCase()}`);
          }
        }} 
      />
      <Text style={styles.resultado}>{saludo}</Text>
    </View>
    
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },

  titulo: {
    fontSize: 18,
    marginBottom: 10,
    color: '#000',
  },

  input: {
    width: '70%',
    borderWidth: 1,
    padding: 10,
    marginBottom: 20,
  },

  resultado: {
    marginTop: 20,
    fontSize: 24,
    fontWeight: "bold",
  }
});