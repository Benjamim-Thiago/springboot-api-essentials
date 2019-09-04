package br.com.btsoftware.service.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class HashUtilTests {

    @Test
    public void getSecureHashText(){
        String hash = HashUtil.getSecureHash("qwe123a45fg");

        System.out.println(hash);

        assertThat(hash.length()).isEqualTo(64);
    }
}
