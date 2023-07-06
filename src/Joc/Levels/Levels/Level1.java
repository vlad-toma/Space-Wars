package Joc.Levels.Levels;

import Joc.Graphics.ImageLoader;
import Joc.Levels.Level;
import Joc.Levels.Waves.Wave1;
import Joc.Levels.Waves.Wave2;
import Joc.Levels.Waves.Wave3;
import Joc.Levels.Waves.Wave4;
import Joc.RefLink;

public class Level1 extends Level {
    public Level1(RefLink refLink) {
        super(refLink, 1);
        background = ImageLoader.LoadImage("/level 1/background1.png");
    }
    @Override
    public void InitLevel() {
        currentWave = 0;
        waves.add(new Wave2(refLink, 1));
        waves.add(new Wave3(refLink, 1));
        waves.add(new Wave1(refLink, 1));
        waves.add(new Wave4(refLink, 1));

    }
}
