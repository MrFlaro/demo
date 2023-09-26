<script>
  import { onMount } from "svelte";
  import { sendFoam, getCount } from "./scripts/Foam";
  import NumberList from "./components/NumberList.svelte";


  let nums = [];
  let bubbles = [];
  let count = 0;

  
  onMount(() => {
    populate();
    setInterval(updateCount, 10000);
  });

  function updateCount() {
    getCount().then((c) => (count = c));
  }

  function populate() {
    nums = Array.from({ length: 10 }, () => Math.floor(Math.random() * 100));
  }

  function sort() {
    sendFoam(nums).then((x) => (bubbles = x));
  }
</script>

<main>
  <h1>Hello Bubble!</h1>
  <h2>Total requests: {count}</h2>
  <div>
    <button on:click={populate}> Generate numbers </button>
    <button on:click={sort}> Bubble it! </button>
  </div>
  <div id="foam">
    <NumberList numbers={nums} />
    <NumberList numbers={bubbles} />
  </div>
</main>

<style>
  #foam {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
  }

  main {
    margin: auto;
    widows: 50%;
    text-align: center;
  }
</style>
