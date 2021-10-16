package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Randoms {

  public   int length = 10;
    public boolean useLetters = true;
    public boolean useNumbers = true;

    public String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
    Random random = new Random();
    public int i = random.nextInt(2);
}
