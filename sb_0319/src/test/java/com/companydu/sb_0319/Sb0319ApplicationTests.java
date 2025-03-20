package com.companydu.sb_0319;

import com.companydu.sb_0319.entity.Memo;
import com.companydu.sb_0319.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class Sb0319ApplicationTests {

	@Autowired
	private MemoRepository memoRepository;

	@Test
	void addMemo() {
		// given
//		Memo memo = new Memo();
//		memo.setContent("Hello World");
		Memo memo = Memo.builder()
				.content("Test").build();

		// when
		memoRepository.save(memo);

		// then
		assertThat(1==1).isTrue();
	}

}
