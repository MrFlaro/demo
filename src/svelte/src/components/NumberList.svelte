<script>
  export let numbers = undefined;
</script>

<div>
  {#if numbers == undefined || numbers.length == 0}
    <p>Empty list</p>
  {:else}
    {#each numbers as number, i}
      <div>
        <p>{i}:  {number}</p>
      </div>
    {/each}
  {/if}
</div>
