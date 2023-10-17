import axios from "axios";

export async function login(email, password) {
  try {
    const response = await axios.post(
      "http://192.168.1.8:8080/trackmyfinance/auth/login",
      {
        email: email,
        password: password,
      }
    );
    const token = response.data.jwt;
    console.log("User logged in!");
    return token;
  } catch (error) {
    // Handle any errors that occurred during the request
    console.error("An error occurred while making the request:", error.stack);
    // You can also throw the error or handle it in a different way
    throw error;
  }
}
export async function createUser(email, password) {
  try {
    const response = await axios.post(
      "http://192.168.1.8:8080/trackmyfinance/auth/registerUser",
      {
        name: "name",
        email: email,
        password: password,
      }
    );
    // Handle the successful response here if needed
    console.log("User created successfully:", response.data);
    const token = response.data.jwt;
    return token;
  } catch (error) {
    // Handle any errors that occurred during the request
    console.error("An error occurred while making the request:", error.stack);
    // You can also throw the error or handle it in a different way
    throw error;
  }
}
