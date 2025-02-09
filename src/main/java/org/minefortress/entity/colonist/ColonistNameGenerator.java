package org.minefortress.entity.colonist;

import net.minecraft.nbt.NbtCompound;
import net.remmintan.mods.minefortress.core.interfaces.entities.IPawnNameGenerator;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColonistNameGenerator implements IPawnNameGenerator {

    private static final List<String> SUPPORTER_NAMES = Arrays.asList(
            "杰夫",
            "特拉维斯",
            "费德",
            "诺亚",
            "雷",
            "蒙奇",
            "亨特",
            "克里斯蒂安",
            "迪恩",
            "莱姆",
            "塔克拉莱",
            "瓦尔内克",
            "布兰登",
            "阿基",
            "格朗吉",
            "朱科兹",
            "特利斯",
            "杰夫·斯托布斯"
    );

    private static final List<String> RANDOM_NAMES = Arrays.asList(
            "詹姆斯",
            "罗伯特",
            "约翰",
            "迈克尔",
            "威廉",
            "大卫",
            "理查德",
            "约瑟夫",
            "托马斯",
            "查尔斯",
            "克里斯托弗",
            "丹尼尔",
            "马修",
            "安东尼",
            "马克",
            "唐纳德",
            "史蒂文",
            "保罗",
            "安德鲁",
            "约书亚",
            "肯尼思",
            "凯文",
            "布莱恩",
            "乔治",
            "爱德华",
            "罗纳德",
            "蒂莫西",
            "杰森",
            "杰弗里",
            "瑞安",
            "雅各布",
            "加里",
            "尼古拉斯",
            "埃里克",
            "乔纳森",
            "斯蒂芬",
            "拉里",
            "贾斯廷",
            "斯科特",
            "布兰登",
            "本杰明",
            "塞缪尔",
            "格雷戈里",
            "弗兰克",
            "亚历山大",
            "雷蒙德",
            "帕特里克",
            "杰克",
            "丹尼斯",
            "杰瑞",
            "泰勒",
            "亚伦",
            "何塞",
            "亚当",
            "亨利",
            "内森",
            "道格拉斯",
            "扎卡里",
            "彼得",
            "凯尔",
            "沃尔特",
            "伊桑",
            "杰里米",
            "哈罗德",
            "基思",
            "克里斯蒂安",
            "罗杰",
            "诺亚",
            "杰拉尔德",
            "卡尔",
            "特里",
            "肖恩",
            "奥斯丁",
            "亚瑟",
            "劳伦斯",
            "杰西",
            "迪伦",
            "布莱恩",
            "乔"
    );


    private final List<String> mandatoryNames;

    public ColonistNameGenerator() {
        mandatoryNames = new ArrayList<>();
        mandatoryNames.addAll(SUPPORTER_NAMES);
    }

    public ColonistNameGenerator(NbtCompound nbtCompound) {
        if(nbtCompound.contains("mandatoryNames")) {
            final String mandatoryNamesString = nbtCompound.getString("mandatoryNames");
            if(Strings.isNotBlank(mandatoryNamesString)) {
                final String[] mandatoryNames = mandatoryNamesString.split(",");
                this.mandatoryNames = new ArrayList<>(Arrays.asList(mandatoryNames));
                return;
            }
        }
        mandatoryNames = new ArrayList<>();
    }

    @Override
    public String generateRandomName() {
        if(!mandatoryNames.isEmpty()) {
            final var name = mandatoryNames.get((int) (Math.random() * mandatoryNames.size()));
            mandatoryNames.remove(name);
            return name;
        } else {
            return RANDOM_NAMES.get((int) (Math.random() * RANDOM_NAMES.size()));
        }
    }

    @Override
    public void write(NbtCompound compound) {
        if(!mandatoryNames.isEmpty()) {
            compound.putString("mandatoryNames", String.join(",", mandatoryNames));
        }
    }

}
