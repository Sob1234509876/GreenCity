package Main;

import javax.sound.sampled.*;
import java.io.File;

/**
 * @ClassName AudioPlay
 * @Description TODO
 * @Author 阡陌
 * @Date 2023/4/13 20:27
 * @Version 1.0
 * @PackageName com.itheima.Test
 */

public class AudioPlay {
    // 音频文件输入流
    private AudioInputStream aio;
    // 控制器
    private Clip bgm;
    // 在暂停和继续音乐时保存文件的毫秒数
    private Long microsecondPosition = new Long(0);

    public boolean isPlay = false;

    /*
     * 构造器，传入要播放的音乐地址
     * filePath=音频文件的地址,用于创建file对象,以及后续的音频流对象
     */
    public AudioPlay(String filePath) {
        try {
            // 创建音频对象
            this.bgm = AudioSystem.getClip();
            // 创建流
            this.aio = AudioSystem.getAudioInputStream(new File(filePath));
            // 开启流
            bgm.open(aio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 播放音乐
     */
    public void start() {
        // 播放音乐
        bgm.setMicrosecondPosition(0);
        bgm.start();
        bgm.loop(Clip.LOOP_CONTINUOUSLY);

        isPlay = true;
    }

    /**
     * 暂停音乐
     */
    public void pause() {
        // 保存当前时间点
        microsecondPosition = bgm.getMicrosecondPosition();
        bgm.loop(Clip.LOOP_CONTINUOUSLY);
        // 暂停音乐
        bgm.stop();

        isPlay = false;
    }

    /**
     * 继续播放
     */
    public void recommence() {
        // 设置上一次暂停位置的毫秒值
        bgm.setMicrosecondPosition(microsecondPosition);
        bgm.loop(Clip.LOOP_CONTINUOUSLY);
        // 从设置位置继续播放
        bgm.start();
        isPlay = true;
    }

    /**
     * 结束播放
     */
    public void stop() {
        // 中断播放
        bgm.stop();
        // 关闭流
        bgm.close();

        isPlay = false;
    }

}