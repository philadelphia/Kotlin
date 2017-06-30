package delegate

/**
 * Created by Tao.ZT.Zhang on 2017/6/30.
 */
class BirdMan(brid: Fly) : Fly by brid {

    override fun canFly() {
//        println("I am a birdMan, But i can't fly")
    }

}