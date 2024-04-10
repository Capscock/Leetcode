class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Initialize a deque to simulate the revealing process
        Deque<Integer> deque = new ArrayDeque<>();
      
        // Sort the deck in ascending order so that we can reveal them in increasing order
        Arrays.sort(deck);

        // Get the length of the deck
        int deckLength = deck.length;
      
        // Start from the last card of the sorted deck,
        // which is the maximum card and simulate the reveal process in reverse
        for (int i = deckLength - 1; i >= 0; --i) {
            // If the deque is not empty, move the last card to the front
            // This simulates the "put the last card on the bottom" step in reverse
            if (!deque.isEmpty()) {
                deque.offerFirst(deque.pollLast());
            }
            // Place the current card on top of the deque
            // This simulates the "reveal the top card" step in reverse
            deque.offerFirst(deck[i]);
        }

        // Initialize an array to store the correctly ordered deck
        int[] result = new int[deckLength];

        // Move cards from the deque back to the result array
        for (int i = deckLength - 1; i >= 0; --i) {
            result[i] = deque.pollLast();
        }

        // Return the result array which has the deck ordered
        // to reveal cards in increasing order
        return result;
    }
}
