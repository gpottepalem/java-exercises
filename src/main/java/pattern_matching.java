import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Scratch {
    public static void main(String[] args) {
        String sonnet = "From fairest creatures we desire increase,\n" +
                            "That thereby beauty's rose might never die,\n" +
                            "But as the riper should by time decease\n" +
                            "His tender heir might bear his memory:\n" +
                            "But thou, contracted to thine own bright eyes,\n" +
                            "Feed'st thy light's flame with self-substantial fuel,\n" +
                            "Making a famine where abundance lies,\n" +
                            "Thyself thy foe, to thy sweet self too cruel.\n" +
                            "Thou that art now the world's fresh ornament,\n" +
                            "And only herald to the gaudy spring,\n" +
                            "Within thine own bud buriest thy content,\n" +
                            "And, tender churl, mak'st waste in niggardly.\n" +
                            "Pity the world, or else this glutton be,\n" +
                            "To eat the world's due, by the grave and thee.";

        String sonnet1 = """
            From fairest creatures we desire increase,
            That thereby beauty's rose might never die,
            But as the riper should by time decease
            His tender heir might bear his memory:
            But thou, contracted to thine own bright eyes,
            Feed'st thy light's flame with self-substantial fuel,
            Making a famine where abundance lies,
            Thyself thy foe, to thy sweet self too cruel.
            Thou that art now the world's fresh ornament,
            And only herald to the gaudy spring,
            Within thine own bud buriest thy content,
            And, tender churl, mak'st waste in niggardly.
            Pity the world, or else this glutton be,
            To eat the world's due, by the grave and thee.""";


        System.out.println(sonnet.length());
        System.out.println(sonnet);
        System.out.println(sonnet1);
        System.out.println(sonnet1.length());
        Pattern pattern = Pattern.compile("\\bflame\\b");
        Matcher matcher = pattern.matcher(sonnet);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(group + " " + start + " " + end);
        }

        String label = """
            "options": [
                {
                  "label": "<p><img alt=\\"\\" title=\\"\\" src=\\"https://webcms.hmhco.com/GetImagePreview.aspx?ImageID=804225\\"></p>\\n\\n<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"cfceaac5-f67e-4dba-b3e9-7eb712be2b5c\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196488\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n",
                  "value": "0"
                },
                {
                  "label": "<p><img alt=\\"\\" title=\\"\\" src=\\"https://webcms.hmhco.com/GetImagePreview.aspx?ImageID=804226\\"></p>\\n\\n<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"3b71af12-c0ce-4f75-9bf9-b174801d10ba\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196487\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n",
                  "value": "1"
                },
                {
                  "label": "<p><img alt=\\"\\" title=\\"\\" src=\\"https://webcms.hmhco.com/GetImagePreview.aspx?ImageID=804227\\" title=\\"\\"></p>\\n\\n<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"36dcd605-2bee-41a2-bf42-0a5d972f6f7a\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196485\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n\\n<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"5874e2bc-5599-4227-90de-bd0cfd327464\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196486\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n\\n<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"1a34ceea-40a6-47d8-8c0a-b8240da0e8c3\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196489\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n",
                  "value": "2"
                }
              ],
              "stimulus": "<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"7b37a38e-ca11-48c2-b780-4a9b692dd519\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196490\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n\\n<p><img alt=\\"\\" title=\\"\\" src=\\"https://webcms.hmhco.com/GetImagePreview.aspx?ImageID=804224\\" title=\\"\\" /></p>\\n\\n<p><span class=\\"learnosity-feature\\" data-player=\\"minimal\\" data-simplefeature_id=\\"73c5beb9-3f9b-4cf2-9d78-be147292f445\\" data-src=\\"https://webcms.hmhco.com/MediaFileRenderer.aspx?MediaFileID=196489\\" data-type=\\"audioplayer\\" data-widget=\\"lrn_simplefeaturewidget\\"></span></p>\\n",
              "type": "mcq",
              "validation": {
                "scoring_type": "exactMatch",
                "valid_response": {
                  "score": 1,
                  "value": [
                    "2"
                  ]
                }
              },
              "ui_style": {
                "type": "horizontal"
              }
            """;
        pattern = Pattern.compile("\\<img\\b");
        matcher = pattern.matcher(label);

        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(group + " " + start + " " + end);
        }
        System.out.println(label.replaceAll("<img", "<img width=\"100\""));
        System.out.println("test".replaceAll("<img", "<img width=\"100\""));
    }
}