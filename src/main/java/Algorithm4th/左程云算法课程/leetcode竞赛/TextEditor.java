package Algorithm4th.左程云算法课程.leetcode竞赛;

public class TextEditor {

    String str;
    int cursor;
    public TextEditor() {
        str = "";
        cursor = 0;
    }

    public void addText(String text) {
        str += text;
        cursor += text.length();
        System.out.println("addText后,str=" + str + ", cursor=" + cursor);
    }

    public int deleteText(int k) {
        System.out.println("cursor = "+cursor+"str="+str);

        if (k>cursor) {
            int yuancur = cursor;
            cursor = 0;
            int strlength = str.length();
            str = str.substring(yuancur, strlength);
            return yuancur;
        }
        int trueNum = Math.min(cursor +1 ,k);
        cursor = cursor - trueNum;
        str = str.substring(0, cursor);
        System.out.println("delete后,str=" + str + ", cursor=" + cursor);
        System.out.println("trueNum" + trueNum);
        return trueNum;
    }

    public String cursorLeft(int k) {
        int trueMoveNum = Math.min(cursor + 1, k);
        cursor = cursor - trueMoveNum;
        System.out.println("左移后：cursor="+ cursor);
        return str.substring(Math.max(cursor - 10,0), cursor);
    }

    public String cursorRight(int k) {
        cursor = cursor + Math.min(k, str.length() - cursor);
        System.out.println("右移后：cursor="+ cursor);
        return str.substring(Math.max(cursor - 10,0), cursor);
    }

    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        textEditor.deleteText(4); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        String res = textEditor.cursorRight(3); // 返回 "etpractice"
        System.out.println(res);
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        String res2 =textEditor.cursorLeft(8); // 返回 "leet"

        System.out.println(res2);
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        textEditor.cursorLeft(2); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.cursorRight(6);
    }
}
