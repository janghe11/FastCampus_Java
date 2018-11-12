package examples.boot.sunnyboard;

import examples.boot.sunnyboard.domain.Board;
import examples.boot.sunnyboard.repository.BoardRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SunnyboardApplicationTests {
	@Autowired
	BoardRepository boardRepository;

	Long id;

	@Test
	public void contextLoads() {
		//해당 메소드가 실행될 때 문제가 없다는 것은 모든 설정이 잘 되어있다는 의미임.
	}

	@Before // Test 전 항상 실행 됨
    public void init() {
        Board board = new Board();
        board.setName("Kim");
        board.setTitle("Kim Title");
        board.setContent("Kim content");
        board.setReadCount(0);

        // 리턴받은 객체는 id에 값이 할당되어있다.
        // 영속성이 부여되어 영속성이 관리가 되는 객체라 부른다.
        board = boardRepository.save(board);
        id = board.getId();
    }

    @After
    public void after() {
	    boardRepository.deleteById(id);
    }

	@Test
	public void saveBoard() throws Exception{
        Board result = boardRepository.getOne(1L);
        Board result2 = boardRepository.getOne(1L);
        result.setTitle("hello java");
		System.out.println(result.getId() + ", " + result.getTitle());
	}



}
