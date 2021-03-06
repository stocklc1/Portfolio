<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateContentAreasTable extends Migration
{

    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('contentAreas', function (Blueprint $table) {
            $table->increments('id');
            $table->string('name')->unique();
            $table->integer('orderBy')->unsigned();
            $table->string('description');
            $table->integer('created_by')->unsigned();
            $table->integer('modified_by')->unsigned();
            $table->rememberToken();
            $table->timestamps();

            // foreign key constraints
            $table->foreign('created_by')->references('id')->on('users');
            $table->foreign('modified_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::drop('contentAreas');
    }

}
