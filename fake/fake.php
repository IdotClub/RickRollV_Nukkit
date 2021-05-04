<?php
$template = file_get_contents("fake.java");
$i = 0;
@mkdir("ff");
while ($i++ < 4096) {
    file_put_contents("ff/FakeClass$i.java", str_replace("[RANDOM]", str_shuffle("qwertyuiopasdfghjklzxcvbnm"), str_replace("[FAKE]", $i, $template)));
}
