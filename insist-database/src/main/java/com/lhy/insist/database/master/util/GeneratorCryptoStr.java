package com.lhy.insist.database.master.util;

import com.baomidou.dynamic.datasource.toolkit.CryptoUtils;

/**
 * @name: GeneratorCryptoStr
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.util.GeneratorCryptoStr
 * @date: 2020/7/13 21:28
 * @Version: 1.0
 */
public class GeneratorCryptoStr {

    public static void main(String[] args) throws Exception {
        //String password = "root";
        String password = "1223";

        String encodePassword = CryptoUtils.encrypt(password);
        System.out.println("encodePassword:--->"+encodePassword);

        //自定义publicKey
        String[] arr = CryptoUtils.genKeyPair(512);
        System.out.println("privateKey:--->" + arr[0]);
        System.out.println("publicKey:--->" + arr[1]);
        System.out.println("password:--->" + CryptoUtils.encrypt(arr[0], password));
    }
}