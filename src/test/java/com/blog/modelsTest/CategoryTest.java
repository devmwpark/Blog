package com.blog.modelsTest;

import com.blog.models.Category;
import com.blog.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "dev")
@Slf4j
@SpringBootTest
@Transactional
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveEntity() throws Exception{
        Category category = new Category();
        category.setName("test");
        category.setDepth(1);

        categoryRepository.save(category);

        Optional<Category> findResult = categoryRepository.findByName("test");

        assertNotNull("test 라는 이름을 가진 정보가 정상 조회 되어야 합니다.",findResult);
        assertThat("ID 는 0보다 큰 숫자가 자동으로 생성 되어야 합니다.",findResult.map(Category::getId).orElse(0L), is(greaterThan(0L)));
        assertNotEquals("createTime 값은 자동생성 되어야 합니다.", Optional.empty(), findResult.map(Category::getCreateTime));
    }
}
