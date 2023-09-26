export {Foam, getFoam, sendFoam, getCount};

class Foam {
    constructor(bubbles)
    {
        this.bubbles = bubbles;
    }

    static from(json){
        return Object.assign(new Foam(), json);
      }
}

const endpoint = "http://localhost:8080/api/bubbles";
async function getFoam(id) {
    const response = await fetch(endpoint + "?id=" + id);

    // fetch(endpoint + "?id=" + id)
    // .then(response => {
    //     console.log(response);
    //     return response.json();
    // })
    // .then(data => {
    //     console.log(data);
    //     foam = data;
    // });
    const value = await response.json();
    return value;
}

async function sendFoam(numbers) {
    // const response = await fetch(endpoint, {
    //     method: "POST",
    //     body: JSON.stringify(new Foam(numbers)),
    // }).json()

    const response = await fetch(endpoint,{
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(new Foam(numbers)),
    });

    const value = await response.json();
    console.log(value);
    return value.bubbles;
}

async function getCount(numbers) {

    const response = await fetch(endpoint);

    const value = await response.json();
    console.log(value);
    return value;
}