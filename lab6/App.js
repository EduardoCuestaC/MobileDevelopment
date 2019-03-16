import React from 'react';
import { StyleSheet, Text, View, Image} from 'react-native';

export default class App extends React.Component {

  constructor(props){
    super(props);
    this.state ={
      firstInput: "",
      stateChanged: false
    }
  }
  displayResult(){
    if(this.state.firstInput !== "")
      this.setState({stateChanged: true});
    else
      this.setState({stateChanged: false});
  }

  render() {
    let pic = {
      uri: 'https://www.w3schools.com/w3css/img_lights.jpg',
      width: 300,
      height: 300
    }
    return (
      <View>
        <View> 
          <Text >Enter your name</Text>
          <TextInput onChangeText={(inputValue) => this.setState({firstInput: inputValue})}  />
        </View>

        <View> 
          <Button onPress={() => {this.displayResult()}} title="Press Here"  />
        </View>

         <View >
           <Text > {this.state.stateChanged ? this.state.firstInput : "" } </Text>
         </View>
        
      </View>
    );
  }
} 

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
