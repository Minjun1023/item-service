package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    // 저장
    public Item save(Item item) {

        // sequence 값에 +1을 하고 id 값에 넣는다.
        item.setId(++sequence);
        // id 값과 item 객체를 store 에 넣는다.
        store.put(item.getId(), item);
        // item 반환
        return item;
    }

    // id로 item 조회
    public Item findById(Long id) {
        // store 에서 id 값으로 item 을 가져와 반환
        return store.get(id);
    }
    // item 전체 조회
    public List<Item> findAll() {
        // store 에서 모든 value 값을 가져와 새로운 배열에 넣고, 반환
        return new ArrayList<>(store.values());
    }
    // 아이템 수정
    public void update(Long itemId, Item updateParam) {
        // id를 통해, item 조회
        Item findItem = findById(itemId);
        // param 정보를 통해, item 값 하나 씩 수정
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    // store 내용 비우기
    public void clearStore() {
        store.clear();
    }
}
