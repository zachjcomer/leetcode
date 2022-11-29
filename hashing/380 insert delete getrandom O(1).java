/*
https://leetcode.com/problems/insert-delete-getrandom-o1/description/

O(1) insert by appending, adding to value-index map, O(1) delete by swapping with array end, updating value-index map, use random lib to get random int for array

time: O(1) -> add via appending, delete via swapping with end then deleting, random via array access w/ random index
space: O(n) -> map to indices and list
*/

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int last = list.get(list.size() - 1);
            int last_i = list.size() - 1;
            int val_i = map.get(val);

            map.put(last, val_i);
            list.set(val_i, last);

            map.remove(val);
            list.remove(last_i);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
